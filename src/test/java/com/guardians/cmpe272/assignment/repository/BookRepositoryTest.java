package com.guardians.cmpe272.assignment.repository;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.guardians.cmpe272.assignment.model.Book;
import com.guardians.cmpe272.assignment.model.Inventory;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext
public class BookRepositoryTest {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private InventoryRepository inventoryRepository;

	@Test
	public void createBookTest() {
		Book book = new Book("123-4567-890", "Test Book", Float.parseFloat("12"));
		book.setBookId(15L);
		bookRepository.save(book);
		
		book = bookRepository.findByTitle("Test Book");
		Inventory inv1 = new Inventory(book, 57);
		inventoryRepository.save(inv1);

		Book book1  = bookRepository.findByTitle("Test Book");
		assertEquals("123-4567-890", book1.getIsbn());
		assertEquals("Test Book", book1.getTitle());
		assertEquals(Float.parseFloat("12"), book1.getPrice(), 0);
	}
	
	@Test
	public void getAllBooksWithCountTest() {
		Book book1 = new Book("111-4567-890", "Test Book 1", Float.parseFloat("10.5"));
		bookRepository.save(book1);
		
		book1 = bookRepository.findByTitle("Test Book 1");
		Inventory inv1 = new Inventory(book1, 57);
		inventoryRepository.save(inv1);
		
		Book book2 = new Book("112-4567-890", "Test Book 2", Float.parseFloat("50"));
		bookRepository.save(book2);
		
		book2 = bookRepository.findByTitle("Test Book 2");
		Inventory inv2 = new Inventory(book2, 11);
		inventoryRepository.save(inv2);
		
		Map<Book, Integer> allBooksWithCount = bookRepository.getAllBooksWithCount();

		assertThat(allBooksWithCount, IsMapContaining.hasValue(57));
		assertThat(allBooksWithCount, IsMapContaining.hasValue(11));
	}

}
