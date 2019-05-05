package com.guardians.cmpe272.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.guardians.cmpe272.assignment.model.Book;
import com.guardians.cmpe272.assignment.model.Inventory;
import com.guardians.cmpe272.assignment.repository.BookRepository;
import com.guardians.cmpe272.assignment.repository.InventoryRepository;
import com.guardians.cmpe272.assignment.exception.ResourceNotFoundException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	// Get All Books
	@GetMapping("/books")
	public List<Book> getAllBooks() {
	    return bookRepository.findAll();
	}
	
	// Get All Books With Count
	@GetMapping("/inventory")
	public List<Inventory> getInventory() {
	    return inventoryRepository.findAll();
	}
	
	// Create a new Book
	@PostMapping("/books")
	public Book createBook(@Valid @RequestBody Book book) {
	    return bookRepository.save(book);
	}
	
	// Get a Single Book
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable(value = "id") Long bookId) {
	    return bookRepository.findById(bookId)
	            .orElseThrow(() -> new ResourceNotFoundException("Book", "id", bookId));
	}
	
	// Get a Single Book by ISBN
	@GetMapping("/books/isbn/{isbn}")
	public Book getBookByISBN(@PathVariable(value = "isbn") String ISBN) {
	    return bookRepository.findByIsbn(ISBN);
	}
	
	// Delete a Book
	@DeleteMapping("/books/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId) {
	    Book book = bookRepository.findById(bookId)
	            .orElseThrow(() -> new ResourceNotFoundException("Book", "id", bookId));

	    bookRepository.delete(book);

	    return ResponseEntity.ok().build();
	}
}
