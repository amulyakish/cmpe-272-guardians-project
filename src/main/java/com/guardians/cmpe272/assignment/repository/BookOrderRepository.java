package com.guardians.cmpe272.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guardians.cmpe272.assignment.model.BookOrder;

@Repository
public interface BookOrderRepository extends JpaRepository<BookOrder, Long>,  BookOrderRepositoryCustom{

}
