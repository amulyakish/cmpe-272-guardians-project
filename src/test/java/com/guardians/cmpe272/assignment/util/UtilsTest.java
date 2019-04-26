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
import com.guardians.cmpe272.assignment.repository.BookRepository;
import com.guardians.cmpe272.assignment.util.Utils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UtilsTest {

	@Autowired
	Utils utils;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Test
	public void readCsvFileTest() throws FileNotFoundException {
		generateTestCSV("test_data.csv");
		utils.readCsvFile("test_data.csv", "Book");
		List<Book> books = bookRepository.findAll();
		
		Book book1 = books.get(0);
		assertEquals(book1.getIsbn(), "123-4567-890");
		assertEquals(book1.getTitle(), "Test Book 5");
		assertEquals(book1.getPrice(), Float.parseFloat("10.5"), 0);
		
		Book book2 = books.get(1);
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
