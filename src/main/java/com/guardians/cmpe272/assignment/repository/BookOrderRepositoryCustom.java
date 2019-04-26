package com.guardians.cmpe272.assignment.repository;

import com.guardians.cmpe272.assignment.model.BookOrder;
import com.guardians.cmpe272.assignment.model.Status;

public interface BookOrderRepositoryCustom {
	
	//<S extends BookOrder> S save(S entity);
	
	public Status fulfillOrder(BookOrder order);
}
