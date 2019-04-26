package com.guardians.cmpe272.assignment.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.guardians.cmpe272.assignment.model.Book;
import com.guardians.cmpe272.assignment.model.Inventory;

@Component
public class BookRepositoryImpl implements BookRepositoryCustom {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Override
	public Map<Book, Integer> getAllBooksWithCount() {
		Map<Book, Integer> bookMap = new HashMap<>();
		
		List<Book> books = bookRepository.findAll();
		for(Book book: books) {
			//Optional<Inventory> inventory = inventoryRepository.findById(book.getBookId());
			List<Inventory> inventory = inventoryRepository.findByBookId(book.getBookId());
			bookMap.put(book, inventory.get(0).getNoOfCopies());
		}
		
		return bookMap;
	}

}
