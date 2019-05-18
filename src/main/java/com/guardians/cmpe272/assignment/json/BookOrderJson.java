package com.guardians.cmpe272.assignment.json;

import java.util.ArrayList;
import java.util.List;

import com.guardians.cmpe272.assignment.model.Book;
import com.guardians.cmpe272.assignment.model.BookOrder;
import com.guardians.cmpe272.assignment.model.OrderLine;
import com.guardians.cmpe272.assignment.model.BookPair;

public class BookOrderJson {
	
	private Long orderId;

	private String customerName;
	
	private String isFulfilled;
	
	private List<BookPair> books;

	/**
	 * 
	 */
	public BookOrderJson() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param orderId
	 * @param customerName
	 * @param isFulfilled
	 * @param books
	 */
	public BookOrderJson(Long orderId, String customerName, String isFulfilled, List<BookPair> books) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.isFulfilled = isFulfilled;
		this.books = books;
	}
	
	public BookOrderJson(BookOrder order) {
		super();
		List<BookPair> booksList = new ArrayList<>();
		this.orderId = order.getOrderId();
		this.customerName = order.getCustomer().getName();
		if(order.getIsFulfilled() != null && order.getIsFulfilled() == true) {
			this.isFulfilled = "Yes";
		}
		else {
			this.isFulfilled = "No";
		}
		for(OrderLine line : order.getOrderLines()) {
			BookPair BookPair = new BookPair(line.getBook().getTitle(), line.getQuantity());
			booksList.add(BookPair);
		}
		this.books = booksList;
	}

	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the isFulfilled
	 */
	public String getIsFulfilled() {
		return isFulfilled;
	}

	/**
	 * @param isFulfilled the isFulfilled to set
	 */
	public void setIsFulfilled(String isFulfilled) {
		this.isFulfilled = isFulfilled;
	}

	/**
	 * @return the books
	 */
	public List<BookPair> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(List<BookPair> books) {
		this.books = books;
	}
}
