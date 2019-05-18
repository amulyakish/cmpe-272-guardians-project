package com.guardians.cmpe272.assignment.repository;

import java.util.List;
import java.util.Map;

import com.guardians.cmpe272.assignment.model.BookOrder;
import com.guardians.cmpe272.assignment.model.Status;
import com.guardians.cmpe272.assignment.model.Customer;
import com.guardians.cmpe272.assignment.model.Pair;
import com.guardians.cmpe272.assignment.model.Book;

public interface BookOrderRepositoryCustom {
	
	//<S extends BookOrder> S save(S entity);
	
	public Long createOrder(Customer customer, List<Pair> orderDetails);
	
	public Status fulfillOrder(Long orderId);
	
	public List<Long> getAllOrderIds();
}
