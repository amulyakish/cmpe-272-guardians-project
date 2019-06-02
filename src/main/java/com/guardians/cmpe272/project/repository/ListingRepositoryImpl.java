package com.guardians.cmpe272.project.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.guardians.cmpe272.project.json.ListingJson;
import com.guardians.cmpe272.project.model.Listing;

public class ListingRepositoryImpl implements ListingRepositoryCustom{

	@Autowired
	ListingRepository listingRepository;
	
	@Override
	public List<ListingJson> getAllListings() {
		List<ListingJson> listingList = new ArrayList<>();
		List<Listing> listings = listingRepository.findAll();
		for(Listing listing: listings) {
			ListingJson json = new ListingJson(listing);
			listingList.add(json);
		}
		return listingList;
	}
	
}
