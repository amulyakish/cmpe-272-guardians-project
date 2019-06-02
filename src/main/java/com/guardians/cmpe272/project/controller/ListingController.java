package com.guardians.cmpe272.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guardians.cmpe272.project.exception.ResourceNotFoundException;
import com.guardians.cmpe272.project.json.ListingJson;
import com.guardians.cmpe272.project.json.PageJson;
import com.guardians.cmpe272.project.model.Listing;
import com.guardians.cmpe272.project.repository.ListingRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ListingController {

	@Autowired
	ListingRepository listingRepository;
	
	// Get All Listings
	@GetMapping("/listings")
	public List<ListingJson> getAllListings() {
		List<ListingJson> listings = listingRepository.getAllListings();
	    return listings;
	}
	
	// Get a Single Listing
	@GetMapping("/listings/{id}")
	public ListingJson getListingById(@PathVariable(value = "id") Long listingId) {
		Optional<Listing> listing = listingRepository.findById(listingId);
		ListingJson json = new ListingJson(listing.get());
	    return json;
	}
	
	
	@RequestMapping(
      value = "/getAll", 
      params = { "page", "size" }, 
      method = RequestMethod.GET
    )
    public PageJson findPaginated(
      @RequestParam("page") int page, @RequestParam("size") int size) {
 
        Page<Listing> resultPage = listingRepository.findAll(new PageRequest(page, size));
        
        List<ListingJson> listingList = new ArrayList<>();
		List<Listing> listings = resultPage.getContent();
		for(Listing listing: listings) {
			/*ListingJson json = new ListingJson(listing.getListingId(), listing.getPictureUrl(), 
					listing.getName(), listing.getPrice(), listing.getReviewScoreRating());*/
			ListingJson json = new ListingJson(listing);
			listingList.add(json);
		}
		
		if (page > resultPage.getTotalPages()) {
            throw new ResourceNotFoundException(null, null, resultPage);
        }
        
		PageJson pageJson = new PageJson(listingList, resultPage.isLast(), 
				resultPage.getTotalElements(), resultPage.getTotalPages(),resultPage.getSize(),
				resultPage.getNumber(), resultPage.getSort(), resultPage.isFirst(), resultPage.getNumberOfElements());  
        
         return pageJson;
    }
}
