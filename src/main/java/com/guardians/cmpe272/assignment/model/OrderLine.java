package com.guardians.cmpe272.assignment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "line")
public class OrderLine implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ORDERLINE_ID_SEQ")
    private Long orderLineId;
    
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
	private BookOrder bookOrder;
    
    @ManyToOne
	@JoinColumn(name = "book_id", nullable = false)
	private Book book;
    
    @Column
	private int quantity;
    
    @Column
    private float itemTotal;

	/**
	 * 
	 */
	public OrderLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param bookOrder
	 * @param book
	 * @param quantity
	 * @param itemTotal
	 */
	public OrderLine(Book book, int quantity, float itemTotal) {
		super();
		this.book = book;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
	}

	/**
	 * @return the bookOrder
	 */
	public BookOrder getBookOrder() {
		return bookOrder;
	}

	/**
	 * @param bookOrder the bookOrder to set
	 */
	public void setBookOrder(BookOrder bookOrder) {
		this.bookOrder = bookOrder;
	}
	
	/**
	 * Associate order line to order
	 *
	 * @param order
	 *            order to which order line will be associated
	 */
	public void associateToOrder(BookOrder order) {
		order.addOrderLine(this);
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
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the itemTotal
	 */
	public float getItemTotal() {
		return itemTotal;
	}

	/**
	 * @param itemTotal the itemTotal to set
	 */
	public void setItemTotal(float itemTotal) {
		this.itemTotal = itemTotal;
	}
	
	/*public void setItemTotal(Book book, int quantity) {
		this.itemTotal = book.getPrice() * quantity;
	}*/

}
