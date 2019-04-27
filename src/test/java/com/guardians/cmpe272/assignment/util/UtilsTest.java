package com.guardians.cmpe272.assignment.util;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guardians.cmpe272.assignment.model.Book;
import com.guardians.cmpe272.assignment.model.Inventory;
import com.guardians.cmpe272.assignment.repository.BookRepository;
import com.guardians.cmpe272.assignment.repository.InventoryRepository;
import com.guardians.cmpe272.assignment.util.Utils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UtilsTest {

	@Autowired
	Utils utils;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Test
	public void readCsvFileTest() throws FileNotFoundException {
		generateTestCSV("test_data.csv");
		utils.readCsvFile("test_data.csv", "Book");
		
		Book book1 = bookRepository.findByTitle("Test Book 5");
		Inventory inv1 = new Inventory(book1, 45);
		inventoryRepository.save(inv1);
		assertEquals(book1.getIsbn(), "123-4567-890");
		assertEquals(book1.getTitle(), "Test Book 5");
		assertEquals(book1.getPrice(), Float.parseFloat("10.5"), 0);
		
		Book book2 = bookRepository.findByTitle("Test Book 6");
		Inventory inv2 = new Inventory(book2, 9);
		inventoryRepository.save(inv2);
		assertEquals(book2.getIsbn(), "223-4567-890");
		assertEquals(book2.getTitle(), "Test Book 6");
		assertEquals(book2.getPrice(), Float.parseFloat("100"), 0);
	}
	
	private void generateTestCSV ( String fileName )
	{
	    try
	    {
	        FileWriter writer = new FileWriter( fileName );
	        writer.append( "123-4567-890" );
	        writer.append( ',' );
	        writer.append( "Test Book 5" );
	        writer.append( ',' );
	        writer.append( "10.5" );
	        writer.append( '\n' );
	        writer.append( "223-4567-890" );
	        writer.append( ',' );
	        writer.append( "Test Book 6" );
	        writer.append( ',' );
	        writer.append( "100" );
	        writer.append( '\n' );
	        writer.flush();
	        writer.close();
	    }
	    catch ( IOException e )
	    {
	        e.printStackTrace();
	    }
	}

}
