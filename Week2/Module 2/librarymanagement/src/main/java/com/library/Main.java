package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class Main {
    public static void main(String[] args) {
        // Load the Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the BookService bean from the context
        BookService bookService = (BookService) context.getBean("bookService");

        // Verify that BookRepository is injected
        System.out.println("BookService Bean: " + bookService);

        // Optionally, test other methods of BookService
        // System.out.println("BookRepository: " + bookService.getBookRepository());
    }
}
