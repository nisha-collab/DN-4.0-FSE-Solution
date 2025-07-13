package com.library;

import com.library.repository.BookRepository;
import com.library.utils.Logger;

public class BookService {
    private BookRepository bookRepository;
    private Logger logger;

    // Constructor for Logger (Constructor Injection)
    public BookService(Logger logger) {
        this.logger = logger;
    }

    // Setter for BookRepository (Setter Injection)
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook() {
        logger.log("BookService: Adding book...");
        bookRepository.saveBook();
    }
}
