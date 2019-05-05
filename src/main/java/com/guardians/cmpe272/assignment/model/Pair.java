package com.guardians.cmpe272.assignment.model;

import org.springframework.stereotype.Component;

@Component
public class Pair {
	
	private Book book;
	
	private Integer copies;
	
	/**
	 * 
	 */
	public Pair() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param book
	 * @param copies
	 */
	public Pair(Book book, Integer copies) {
		super();
		this.book = book;
		this.copies = copies;
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
	 * @return the copies
	 */
	public Integer getCopies() {
		return copies;
	}

	/**
	 * @param copies the copies to set
	 */
	public void setCopies(Integer copies) {
		this.copies = copies;
	}

}
