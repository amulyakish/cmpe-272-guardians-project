package com.guardians.cmpe272.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.guardians.cmpe272.assignment.model.Book;
import com.guardians.cmpe272.assignment.model.Inventory;

public interface InventoryRepositoryCustom {
	
	public List<Inventory> findByBookId(Long bookId);
	
	public Inventory findByBookName(String bookName);
}
