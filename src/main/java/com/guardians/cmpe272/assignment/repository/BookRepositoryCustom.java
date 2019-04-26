package com.guardians.cmpe272.assignment.repository;

import java.util.Map;
import com.guardians.cmpe272.assignment.model.Book;

public interface BookRepositoryCustom {

	public Map<Book, Integer> getAllBooksWithCount();
}
