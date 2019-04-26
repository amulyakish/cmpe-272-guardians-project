package com.guardians.cmpe272.assignment.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "book_order")
public class BookOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
    
    private float orderTotal;
    
    @OneToMany(mappedBy = "bookOrder")
	private final Set<OrderLine> orderLines = new HashSet<>();
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @Type(type = "yes_no")
    @Column
    private Boolean isFulfilled;

	/**
	 * 
	 */
	public BookOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param customer
	 * @param orderTotal
	 * @param createdAt
	 */
	public BookOrder(Customer customer, float orderTotal, Date createdAt) {
		super();
		this.customer = customer;
		this.orderTotal = orderTotal;
		this.createdAt = createdAt;
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
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the orderTotal
	 */
	public float getOrderTotal() {
		return orderTotal;
	}

	/**
	 * @param orderTotal the orderTotal to set
	 */
	public void setOrderTotal(float orderTotal) {
		this.orderTotal = orderTotal;
	}

	/**
	 * @return the orderLines
	 */
	public Set<OrderLine> getOrderLines() {
		return orderLines;
	}
	
	/**
	 * Add orderLine to order
	 *
	 * @param line
	 *            Order Line
	 */
	public void addOrderLine(OrderLine line) {
		line.setBookOrder(this);
		this.getOrderLines().add(line);
	}

	/**
	 * @return the isFulfilled
	 */
	public Boolean getIsFulfilled() {
		return isFulfilled;
	}

	/**
	 * @param isFulfilled the isFulfilled to set
	 */
	public void setIsFulfilled(Boolean isFulfilled) {
		this.isFulfilled = isFulfilled;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
