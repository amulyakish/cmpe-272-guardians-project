package com.guardians.cmpe272.assignment.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.guardians.cmpe272.assignment.model.Book;
import com.guardians.cmpe272.assignment.model.Inventory;
import com.guardians.cmpe272.assignment.repository.BookRepository;
import com.guardians.cmpe272.assignment.repository.InventoryRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BookController.class, secure = false)
public class BookControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BookRepository bookRepository;
	
	@MockBean
	private InventoryRepository inventoryRepository;
	
	List<Book> books = new ArrayList<Book>();
	List<Inventory> inv = new ArrayList<Inventory>();
	
	@Before
	public void setUp() {
		Book book1 = new Book("110-4567-890", "Test Book 11", Float.parseFloat("10.5"));		
		Book book2 = new Book("101-4567-890", "Test Book 12", Float.parseFloat("50"));
		
		Inventory inv1 = new Inventory(book1, 57);
		Inventory inv2 = new Inventory(book2, 33);
		
		books.add(book1);
		books.add(book2);
		
		inv.add(inv1);
		inv.add(inv2);
	}
	
	@After
    public void finalize() {
        books.clear();
        inv.clear();
    }

	@Test
	public void getAllBooksWithCountTest() throws Exception{
		Mockito.when(inventoryRepository.findAll()).thenReturn(inv);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/inventory");

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String res = result.getResponse().getContentAsString();
		System.out.println("All books with count: " + res);
		String expected = "[{\"inventoryId\":null,\"book\":{\"bookId\":null,\"isbn\":\"110-4567-890\",\"title\":\"Test Book 11\",\"price\":10.5},\"noOfCopies\":57},{\"inventoryId\":null,\"book\":{\"bookId\":null,\"isbn\":\"101-4567-890\",\"title\":\"Test Book 12\",\"price\":50.0},\"noOfCopies\":33}]";
		JSONAssert.assertEquals(expected, res, false);
	}
	
	@Test
	public void getBookByISBNTestPositive() throws Exception {
		Mockito.when(bookRepository.findByIsbn(Mockito.anyString())).thenReturn(books.get(1));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/books/isbn/101-4567-890");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String res = result.getResponse().getContentAsString();
		String expected = "{\"bookId\":null,\"isbn\":\"101-4567-890\",\"title\":\"Test Book 12\",\"price\":50.0}";
		String res1 = "{" + expected + ",\"noOfCopies\":33}";
		System.out.println("Book by ISBN - Test 1: " + res1);		
		JSONAssert.assertEquals(expected, res, false);
	}
	
	@Test
	public void getBookByISBNTestNegative() throws Exception {
		String res1 = "{\"error\":\"Book Does Not Exist\"}";
		Mockito.when(bookRepository.findByIsbn(Mockito.anyString())).thenReturn(books.get(1));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/books/isbn/101-4567-999");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String res = result.getResponse().getContentAsString();
		String expected = "{\"bookId\":null,\"isbn\":\"101-4567-890\",\"title\":\"Test Book 12\",\"price\":50.0}";		
		System.out.println("Book by ISBN - Test 2: " + res1);		
		JSONAssert.assertEquals(expected, res, false);
	}

}
