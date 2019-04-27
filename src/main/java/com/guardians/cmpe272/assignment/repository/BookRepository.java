package com.guardians.cmpe272.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.guardians.cmpe272.assignment.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>,  BookRepositoryCustom {
	Book findByTitle(String title);
}
