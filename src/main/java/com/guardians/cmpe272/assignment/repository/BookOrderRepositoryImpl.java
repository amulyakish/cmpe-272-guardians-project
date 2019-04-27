package com.guardians.cmpe272.assignment.repository;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.guardians.cmpe272.assignment.model.BookOrder;
import com.guardians.cmpe272.assignment.model.Inventory;
import com.guardians.cmpe272.assignment.model.OrderLine;
import com.guardians.cmpe272.assignment.model.Status;
import com.guardians.cmpe272.assignment.model.Status.Error;

public class BookOrderRepositoryImpl implements BookOrderRepositoryCustom{

	@Autowired
	InventoryRepository inventoryRepository;

	@Override
	public Status fulfillOrder(BookOrder order) {
		Status status = new Status();
		if(order.getIsFulfilled() == null && validateOrder(order) == 1) {
			for (OrderLine line : order.getOrderLines()) {
				List<Inventory> inventory = inventoryRepository.findByBookId(line.getBook().getBookId());
				inventory.get(0).setNoOfCopies(inventory.get(0).getNoOfCopies() - line.getQuantity());
				inventoryRepository.save(inventory.get(0));
			}				
			order.setIsFulfilled(Boolean.TRUE);
			status.setOrderFulfillStatus(1);
			status.setError(Error.SUCCESS);
		}
		else if(validateOrder(order) == 0){
			status.setOrderFulfillStatus(0);
			status.setError(Error.OUT_OF_STOCK);
		}
		else {
			status.setOrderFulfillStatus(0);
			status.setError(Error.UNKNOWN_ERROR);
		}	
		
		return status;
	}
	
	private int validateOrder(BookOrder order) {
		return 1;
		/*Set<OrderLine> orderLines = order.getOrderLines();
		for (OrderLine line : orderLines) {
			Inventory inventory = inventoryRepository.findByBook(line.getBook());
			if(line.getQuantity() <= inventory.getNoOfCopies()) {
				continue;
			}
			else {
				return 0;
			}
		}		
		return 1;*/
	}

}
