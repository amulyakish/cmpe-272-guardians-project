package com.guardians.cmpe272.project.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guardians.cmpe272.project.json.ListingJson;
import com.guardians.cmpe272.project.model.Comment;
import com.guardians.cmpe272.project.model.Listing;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ListingRepositoryTest {

	@Autowired
	ListingRepository listingRepository;
	
	@Test
	public void getAllListingsTest() {
		Listing listing1 = new Listing("http://airbnb.com/pictures/picture1.jpg","name","description",0,
				"hostname",2,1,1,0,"No free cancellation","everything you'd want",
				"Palace of Lights","CA");
		listing1.setListingId(1L);
		Comment comment1 = new Comment("comment 1");
		comment1.associateToListing(listing1);
		
		Listing listing2 = new Listing("http://airbnb.com/pictures/picture2.jpg","name","description",0,
				"hostname",2,1,1,0,"No free cancellation","everything you'd want",
				"Palace of Lights","CA");
		listing2.setListingId(2L);
		Comment comment2 = new Comment("comment 2");
		comment2.associateToListing(listing2);
		
		listingRepository.save(listing1);
		listingRepository.save(listing2);
		
		List<ListingJson> allListings = listingRepository.getAllListings();		
		
		List<ListingJson> listingList = new ArrayList<>();
		listingList.add(new ListingJson(listing1));
		listingList.add(new ListingJson(listing2));
		
		assertTrue(allListings.size() == listingList.size());
	}

}
