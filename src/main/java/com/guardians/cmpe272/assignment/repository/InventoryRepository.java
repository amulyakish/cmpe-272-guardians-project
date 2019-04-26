package com.guardians.cmpe272.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.guardians.cmpe272.assignment.model.Book;
import com.guardians.cmpe272.assignment.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>,InventoryRepositoryCustom{
	
	/*@Query(value = "SELECT * FROM INVENTORY WHERE BOOK_ID = ?1", nativeQuery = true)
	public List<Inventory> findByBookId(Long bookId);*/
	
}
