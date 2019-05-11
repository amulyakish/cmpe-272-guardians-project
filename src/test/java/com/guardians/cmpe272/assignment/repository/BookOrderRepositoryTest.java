package com.guardians.cmpe272.assignment.repository;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guardians.cmpe272.assignment.model.Book;
import com.guardians.cmpe272.assignment.model.BookOrder;
import com.guardians.cmpe272.assignment.model.Customer;
import com.guardians.cmpe272.assignment.model.Inventory;
import com.guardians.cmpe272.assignment.model.OrderLine;
import com.guardians.cmpe272.assignment.model.Status;
import com.guardians.cmpe272.assignment.model.Status.Error;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookOrderRepositoryTest {

	@Autowired
	BookOrderRepository orderRepository;
	
	@Autowired
	OrderLineRepository orderLineRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Test
	public void createOrderTest() {
		Book book1 = new Book("110-4567-890", "Test Book 7", Float.parseFloat("10.5"));
		bookRepository.save(book1);		
		
		Book book2 = new Book("101-4567-890", "Test Book 8", Float.parseFloat("50"));
		bookRepository.save(book2);
		
		book1 = bookRepository.findByTitle("Test Book 7");
		Inventory inv1 = new Inventory(book1, 57);
		inventoryRepository.save(inv1);
		
		book2 = bookRepository.findByTitle("Test Book 8");
		Inventory inv2 = new Inventory(book2, 33);
		inventoryRepository.save(inv2);
		
		createCustomer();
		Customer customer = customerRepository.findAll().get(0);
		
		BookOrder order = new BookOrder(customer, 0, new Date());
		OrderLine line1 = new OrderLine(book1, 2, book1.getPrice()*2);
		OrderLine line2 = new OrderLine(book2, 1, book2.getPrice()*1);
		float orderTotal = (book1.getPrice()*2) + (book2.getPrice()*1);
		order.setOrderTotal(orderTotal);
		line1.associateToOrder(order);
		line2.associateToOrder(order);
		
		orderRepository.save(order);

		assertEquals(71, orderTotal, 0);		
	}
	
	@Test
	public void fulfillOrderTest1() {
		createBooks();
		createCustomer();
		Customer customer = customerRepository.findAll().get(0);

		Book book1  = bookRepository.findByTitle("Test Book 3");
		Book book2  = bookRepository.findByTitle("Test Book 4");
		
		BookOrder order = new BookOrder(customer, 0, new Date());
		OrderLine line1 = new OrderLine(book1, 2, book1.getPrice()*2);
		OrderLine line2 = new OrderLine(book2, 1, book2.getPrice()*1);
		float orderTotal = (book1.getPrice()*2) + (book2.getPrice()*1);
		order.setOrderTotal(orderTotal);
		line1.associateToOrder(order);
		line2.associateToOrder(order);
		
		orderRepository.save(order);
		
		Status status = orderRepository.fulfillOrder(order.getOrderId());
		
		assertEquals(1, status.getOrderFulfillStatus());
		assertEquals(Error.SUCCESS, status.getError());
		
		List<Inventory> inv1 = inventoryRepository.findByBookId(book1.getBookId());
		List<Inventory> inv2 = inventoryRepository.findByBookId(book2.getBookId());
		
		assertEquals(55, inv1.get(0).getNoOfCopies());
		assertEquals(32, inv2.get(0).getNoOfCopies());
	}
	
	private void createCustomer() {
		Customer customer = new Customer("Test Customer", "test@test.com", "100 Church Street");
		customerRepository.save(customer);
	}
	
	private void createBooks() {
		Book book1 = new Book("110-4567-890", "Test Book 3", Float.parseFloat("10.5"));
		bookRepository.save(book1);		
		
		Book book2 = new Book("101-4567-890", "Test Book 4", Float.parseFloat("50"));
		bookRepository.save(book2);

		book1 = bookRepository.findByTitle("Test Book 3");
		Inventory inv1 = new Inventory(book1, 57);
		inventoryRepository.save(inv1);
		
		book2 = bookRepository.findByTitle("Test Book 4");
		Inventory inv2 = new Inventory(book2, 33);
		inventoryRepository.save(inv2);
		
		List<Inventory> inventory = inventoryRepository.findAll();
		inventory.get(0);
	}
}
