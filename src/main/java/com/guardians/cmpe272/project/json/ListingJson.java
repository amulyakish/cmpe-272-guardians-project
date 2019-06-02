package com.guardians.cmpe272.project.json;

import java.util.ArrayList;
import java.util.List;

import com.guardians.cmpe272.project.model.Comment;
import com.guardians.cmpe272.project.model.Listing;

public class ListingJson {

	private Long listingId;
    
    private String pictureUrl;    
    
    private String name;    
    
    private String description;
    
    private float price;    
    
    private String hostname;
    
    private Integer accomodates;
    
    private Integer beds;
    
    private Integer bathrooms;
    
    private float reviewScoreRating;    
    
    private String cancellationPolicy;    
    
    private String amenities;    
    
    private String city;    
    
    private String state;
    
    private List<String> reviews;

	/**
	 * 
	 */
	public ListingJson() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListingJson(Listing listing) {
		super();
		List<String> commentsList = new ArrayList<>();
		this.listingId = listing.getListingId();
		this.pictureUrl = listing.getPictureUrl();
		this.name = listing.getName();
		this.description = listing.getDescription();
		this.price = listing.getPrice();
		this.hostname = listing.getHostname();
		this.accomodates = listing.getAccomodates();
		this.beds = listing.getBeds();
		this.bathrooms = listing.getBathrooms();
		this.reviewScoreRating = listing.getReviewScoreRating();
		this.cancellationPolicy = listing.getCancellationPolicy();
		this.amenities = listing.getAmenities();
		this.city = listing.getCity();
		this.state = listing.getState();
		
		for(Comment comment : listing.getComments()) {
			commentsList.add(comment.getComments());
		}		
		this.reviews = commentsList;
	}
	
	/**
	 * @param listingId
	 * @param pictureUrl
	 * @param name
	 * @param description
	 * @param price
	 * @param hostname
	 * @param accomodates
	 * @param beds
	 * @param bathrooms
	 * @param reviewScoreRating
	 * @param cancellationPolicy
	 * @param amenities
	 * @param city
	 * @param state
	 */
	public ListingJson(Long listingId, String pictureUrl, String name, String description, float price, String hostname,
			Integer accomodates, Integer beds, Integer bathrooms, float reviewScoreRating, String cancellationPolicy,
			String amenities, String city, String state) {
		super();
		this.listingId = listingId;
		this.pictureUrl = pictureUrl;
		this.name = name;
		this.description = description;
		this.price = price;
		this.hostname = hostname;
		this.accomodates = accomodates;
		this.beds = beds;
		this.bathrooms = bathrooms;
		this.reviewScoreRating = reviewScoreRating;
		this.cancellationPolicy = cancellationPolicy;
		this.amenities = amenities;
		this.city = city;
		this.state = state;
	}
	
	public ListingJson(Long listingId, String pictureUrl, String name, float price, float reviewScoreRating) {
		super();
		this.listingId = listingId;
		this.pictureUrl = pictureUrl;
		this.name = name;
		this.price = price;
		this.reviewScoreRating = reviewScoreRating;
	}

	/**
	 * @return the listingId
	 */
	public Long getListingId() {
		return listingId;
	}

	/**
	 * @param listingId the listingId to set
	 */
	public void setListingId(Long listingId) {
		this.listingId = listingId;
	}

	/**
	 * @return the pictureUrl
	 */
	public String getPictureUrl() {
		return pictureUrl;
	}

	/**
	 * @param pictureUrl the pictureUrl to set
	 */
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the hostname
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * @param hostname the hostname to set
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	/**
	 * @return the accomodates
	 */
	public Integer getAccomodates() {
		return accomodates;
	}

	/**
	 * @param accomodates the accomodates to set
	 */
	public void setAccomodates(Integer accomodates) {
		this.accomodates = accomodates;
	}

	/**
	 * @return the beds
	 */
	public Integer getBeds() {
		return beds;
	}

	/**
	 * @param beds the beds to set
	 */
	public void setBeds(Integer beds) {
		this.beds = beds;
	}

	/**
	 * @return the bathrooms
	 */
	public Integer getBathrooms() {
		return bathrooms;
	}

	/**
	 * @param bathrooms the bathrooms to set
	 */
	public void setBathrooms(Integer bathrooms) {
		this.bathrooms = bathrooms;
	}

	/**
	 * @return the reviewScoreRating
	 */
	public float getReviewScoreRating() {
		return reviewScoreRating;
	}

	/**
	 * @param reviewScoreRating the reviewScoreRating to set
	 */
	public void setReviewScoreRating(float reviewScoreRating) {
		this.reviewScoreRating = reviewScoreRating;
	}

	/**
	 * @return the cancellationPolicy
	 */
	public String getCancellationPolicy() {
		return cancellationPolicy;
	}

	/**
	 * @param cancellationPolicy the cancellationPolicy to set
	 */
	public void setCancellationPolicy(String cancellationPolicy) {
		this.cancellationPolicy = cancellationPolicy;
	}

	/**
	 * @return the amenities
	 */
	public String getAmenities() {
		return amenities;
	}

	/**
	 * @param amenities the amenities to set
	 */
	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the reviews
	 */
	public List<String> getReviews() {
		return reviews;
	}

	/**
	 * @param reviews the reviews to set
	 */
	public void setReviews(List<String> reviews) {
		this.reviews = reviews;
	}
}
