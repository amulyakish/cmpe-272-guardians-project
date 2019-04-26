package com.guardians.cmpe272.assignment.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guardians.cmpe272.assignment.model.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void createCustomerTest() {
		Customer customer = new Customer("Test Customer", "test@test.com", "100 Church Street");
		customerRepository.save(customer);
		
		List<Customer> customers = customerRepository.findAll();
		Customer cust = customers.get(0);
		assertEquals(cust.getName(), "Test Customer");
		assertEquals(cust.getEmail(), "test@test.com");
		assertEquals(cust.getAddress(), "100 Church Street");
	}

}
