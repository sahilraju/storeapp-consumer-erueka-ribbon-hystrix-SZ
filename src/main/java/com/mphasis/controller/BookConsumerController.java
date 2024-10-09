package com.mphasis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.domain.Book;
import com.mphasis.service.BookService;

@RestController
@RequestMapping("/consumer/book")
public class BookConsumerController {

	@Autowired
	private BookService bookService;
	
	private static final Logger log = LoggerFactory.getLogger(BookConsumerController.class);  

	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Long id) {
		
		System.out.println(id+"//////////////");
		
		log.debug("In getBookById with Id: "+ id);

		Book book = bookService.getBookById(id);  
		log.debug("In getBookById with return valuebook: "+ book); 
		return book;

	}

}
