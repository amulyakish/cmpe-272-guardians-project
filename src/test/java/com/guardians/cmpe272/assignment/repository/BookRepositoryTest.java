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
	@DirtiesContext
	public void createBookTest() {
		Book book = new Book("123-4567-890", "Test Book", Float.parseFloat("12"));
		book.setBookId(15L);
		bookRepository.save(book);
		
		List<Book> books = bookRepository.findAll();
		Book book1 = books.get(0);
		assertEquals("123-4567-890", book1.getIsbn());
		assertEquals("Test Book", book1.getTitle());
		assertEquals(Float.parseFloat("12"), book1.getPrice(), 0);
	}
	
	@Test
	@DirtiesContext
	public void getAllBooksWithCountTest() {
		Book book1 = new Book("111-4567-890", "Test Book 1", Float.parseFloat("10.5"));
		book1.setBookId(1L);
		bookRepository.save(book1);
		
		Inventory inv1 = new Inventory(book1, 57);
		inventoryRepository.save(inv1);
		
		Book book2 = new Book("112-4567-890", "Test Book 2", Float.parseFloat("50"));
		book2.setBookId(2L);
		bookRepository.save(book2);
		
		Inventory inv2 = new Inventory(book2, 11);
		inventoryRepository.save(inv2);
		
		Map<Book, Integer> allBooksWithCount = bookRepository.getAllBooksWithCount();
		
		Map<Book, Integer> expected = new HashMap<>();
		expected.put(book1, 57);
		expected.put(book2, 11);
		
		assertThat(allBooksWithCount.size(), is(2));	
		assertThat(allBooksWithCount, IsMapContaining.hasValue(57));
		assertThat(allBooksWithCount, IsMapContaining.hasValue(11));
	}

}
