package com.guardians.cmpe272.assignment.model;

public class BookPair {
	
	private String bookName;
	
	private int copies;

	/**
	 * 
	 */
	public BookPair() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param bookName
	 * @param copies
	 */
	public BookPair(String bookName, int copies) {
		super();
		this.bookName = bookName;
		this.copies = copies;
	}

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the copies
	 */
	public int getCopies() {
		return copies;
	}

	/**
	 * @param copies the copies to set
	 */
	public void setCopies(int copies) {
		this.copies = copies;
	}

}
