package com.guardians.cmpe272.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Comment implements Serializable{

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "REVIEW_ID_SEQ")
    private Long reviewerId;
	
	@Column
    private String comments;
	
	@ManyToOne
    @JoinColumn(name = "listing_id", nullable = false)
	private Listing listing;

	/**
	 * 
	 */
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param reviewId
	 * @param review
	 */
	public Comment(String comments) {
		super();
		this.comments = comments;
	}

	/**
	 * @return the review
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param review the review to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the reviewId
	 */
	public Long getReviewerId() {
		return reviewerId;
	}

	/**
	 * @param reviewId the reviewId to set
	 */
	public void setReviewerId(Long reviewerId) {
		this.reviewerId = reviewerId;
	}

	/**
	 * @return the listing
	 */
	public Listing getListing() {
		return listing;
	}

	/**
	 * @param listing the listing to set
	 */
	public void setListing(Listing listing) {
		this.listing = listing;
	}
	
	/**
	 * Associate comment to listing
	 *
	 * @param listing
	 *            listing to which comment will be associated
	 */
	public void associateToListing(Listing listing) {
		listing.addComment(this);
	}
}
