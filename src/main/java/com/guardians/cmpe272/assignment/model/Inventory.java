package com.guardians.cmpe272.assignment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

	@OneToOne
	@JoinColumn(name = "book_id", nullable = false)
	private Book book;
	
	@Column
	private int noOfCopies;

	/**
	 * 
	 */
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param inventoryId
	 * @param book
	 * @param noOfCopies
	 */
	public Inventory(Book book, int noOfCopies) {
		super();
		this.book = book;
		this.noOfCopies = noOfCopies;
	}

	/**
	 * @return the inventoryId
	 */
	public Long getInventoryId() {
		return inventoryId;
	}

	/**
	 * @param inventoryId the inventoryId to set
	 */
	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * @return the noOfCopies
	 */
	public int getNoOfCopies() {
		return noOfCopies;
	}

	/**
	 * @param noOfCopies the noOfCopies to set
	 */
	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

}
