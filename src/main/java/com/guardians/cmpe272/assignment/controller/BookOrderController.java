package com.guardians.cmpe272.assignment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guardians.cmpe272.assignment.model.BookOrder;
import com.guardians.cmpe272.assignment.model.Status;
import com.guardians.cmpe272.assignment.repository.BookOrderRepository;


@RestController
@RequestMapping("/bookorder")
public class BookOrderController {
	
	@Autowired
	BookOrderRepository orderRepository;

	// Create a new Order
	@PostMapping(path="/order", consumes = "application/json")
	public BookOrder createOrder(@RequestBody BookOrder order) {		
	    return orderRepository.save(order);
	}
	
	// Fulfill an Order
	@PostMapping(path="/fulfill", consumes = "application/json")
	public Status fulfillOrder(@RequestBody BookOrder order) {		
	    return orderRepository.fulfillOrder(order);
	}
}
