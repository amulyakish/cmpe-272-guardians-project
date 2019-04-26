package com.guardians.cmpe272.assignment.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.guardians.cmpe272.assignment.model.Inventory;

public class InventoryRepositoryImpl implements InventoryRepositoryCustom{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Inventory> findByBookId(Long bookId) {
		final StringBuilder query = new StringBuilder("select inventory from Inventory inventory ")
				.append(" where inventory.book.id = :bookId ");
		
		return em.createQuery(query.toString())
				.setParameter("bookId", bookId.longValue())
				.getResultList();
	}

}
