package com.guardians.cmpe272.assignment.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.guardians.cmpe272.assignment.model.Book;
import com.guardians.cmpe272.assignment.repository.BookRepository;

@Component
public class Utils {
	
	@Autowired
	private BookRepository bookRepository;
	
	public void readCsvFile(String csvFile, String type) throws FileNotFoundException {
		String line = "";
		String cvsSplitBy = ",";
		BufferedReader br = new BufferedReader( new FileReader( csvFile ) );
		try {
			while ((line = br.readLine()) != null) {
                String[] entity = line.split(cvsSplitBy);
                if(type.equals("Book") && entity.length == 3) {
                	this.createBook(entity);
                }
			}
		} catch ( FileNotFoundException e )
	    {
			e.getCause().printStackTrace();
	    }
	    catch ( IOException e )
	    {
	    	e.getCause().printStackTrace();
	    }
		finally
	    {
	        if ( br != null )
	        {
	            try
	            {
	                br.close();
	            }
	            catch ( IOException e )
	            {
	            	e.getCause().printStackTrace();
	            }
	        }
	    }
	}

	private void createBook(String[] entity) {
		if(entity.length == 3) {
			Book book = new Book(entity[0], entity[1], Float.parseFloat(entity[2]));
			//book.setBookId(15L);
			//Book book = new Book("123-4567-890", "Test Book", Float.parseFloat("12"));
			//book.setBookId(15L);
			bookRepository.save(book);
			
			//List<Book> books = bookRepository.findAll();
			//Book book1 = books.get(0);
			
			//System.out.println(book1.getTitle());
		}		
	}

}
