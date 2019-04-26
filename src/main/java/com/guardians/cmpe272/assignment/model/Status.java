package com.guardians.cmpe272.assignment.model;

import org.springframework.stereotype.Component;

@Component
public class Status {
	
	private int orderFulfillStatus;

	private Error error;
	
	public enum Error {

		SUCCESS,
		
		OUT_OF_STOCK,

		UNKNOWN_ERROR;
	}

	/**
	 * 
	 */
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param orderFulfillStatus
	 * @param error
	 */
	public Status(int orderFulfillStatus, Error error) {
		super();
		this.orderFulfillStatus = orderFulfillStatus;
		this.error = error;
	}

	/**
	 * @return the orderFulfillStatus
	 */
	public int getOrderFulfillStatus() {
		return orderFulfillStatus;
	}

	/**
	 * @param orderFulfillStatus the orderFulfillStatus to set
	 */
	public void setOrderFulfillStatus(int orderFulfillStatus) {
		this.orderFulfillStatus = orderFulfillStatus;
	}

	/**
	 * @return the error
	 */
	public Error getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(Error error) {
		this.error = error;
	} 

}
