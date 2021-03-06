package com.guardians.cmpe272.project.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "listing")
public class Listing implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "LISTING_ID_SEQ")
    private Long listingId;

    @Column
    private String pictureUrl;
    
    @Column
    private String name;
    
    @Column
    private String description;
    
    private float price;
    
    @Column
    private String hostname;
    
    private Integer accomodates;
    
    private Integer beds;
    
    private Integer bathrooms;
    
    private float reviewScoreRating;
    
    @Column
    private String cancellationPolicy;
    
    @Column
    private String amenities;
    
    @Column
    private String city;
    
    @Column
    private String state;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "listing", cascade = CascadeType.ALL)
	private final Set<Comment> comments = new HashSet<>();

	/**
	 * 
	 */
	public Listing() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
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
	 * @param comments
	 */
	public Listing(String pictureUrl, String name, String description, float price, String hostname,
			Integer accomodates, Integer beds, Integer bathrooms, float reviewScoreRating, String cancellationPolicy,
			String amenities, String city, String state) {
		super();
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
	 * @return the comments
	 */
	public Set<Comment> getComments() {
		return comments;
	}
	
	/**
	 * Add orderLine to order
	 *
	 * @param line
	 *            Order Line
	 */
	public void addComment(Comment comment) {
		comment.setListing(this);
		this.getComments().add(comment);
	}
	
	public void setComment(Comment comment) {
		this.addComment(comment);
	}
}
