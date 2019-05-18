package com.guardians.cmpe272.assignment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guardians.cmpe272.assignment.model.BookOrder;
import com.guardians.cmpe272.assignment.model.OrderLine;
import com.guardians.cmpe272.assignment.model.Status;
import com.guardians.cmpe272.assignment.repository.BookOrderRepository;


@RestController
@RequestMapping("/bookorder")
public class BookOrderController {
	
	@Autowired
	BookOrderRepository orderRepository;

	// Create a new Order
	@PostMapping(path="/order", consumes = "application/json")
	public String createOrder(@RequestBody BookOrder order) {	
		for(OrderLine line : order.getOrderLines()) {
			line.associateToOrder(order);
		}
		BookOrder createdOrder = orderRepository.save(order);
		String response = "{\"orderId\":" + createdOrder.getOrderId().toString() + "}";
	    return response;
	}
	
	@GetMapping("/allOrders")
	public List<Long> getAllOrders() {
		return orderRepository.getAllOrderIds();
	}
	
	// Fulfill Order
	@PutMapping(path="/fulfill/{orderId}", consumes = "application/json")
	public Status fulfillOrder(@PathVariable Long orderId) {	
		String response;
		Status status = orderRepository.fulfillOrder(orderId);
		if(status.getOrderFulfillStatus() == 1) {
			response = "{\"Success\": \"True\"}";
		}
		else {
			response = "{\"Success\": \"False\", \"Error\" :" + status.getError() + "}";
		}
		System.out.println(response);
	    return status;
	}
}
