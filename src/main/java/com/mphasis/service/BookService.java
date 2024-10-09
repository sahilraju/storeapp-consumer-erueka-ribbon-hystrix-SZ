package com.mphasis.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mphasis.domain.Book;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class BookService {
	
	@Autowired
	private RestTemplate restTemplate;
	

	@HystrixCommand(fallbackMethod = "fallbackGetBookById")
	public Book getBookById(Long id) { 
		
		System.out.println(id+"//////////////");

		Book book = restTemplate.getForObject("http://book-service/book/" + id, Book.class);

		return book;

	}
	
	public Book fallbackGetBookById(Long id) {
		
		return new Book(id, "title", "author", "isbn", 100, 2100, "publisher"); 
		
	}

}
