package com.bookstore.service;

import com.bookstore.dto.BookDto;
import com.bookstore.exception.ResourceNotFoundException;
import com.bookstore.model.Book;

import java.util.List;
import java.util.Map;

public interface BookStoreService {

    BookDto createBooks(BookDto book);

    Book updateBooks(long bookId, Book bookDetails) throws ResourceNotFoundException;

    List<BookDto> getAllBooks();

    Book getBookById(long bookId) throws ResourceNotFoundException;

    Map<String, Boolean> deleteBook(long bookId) throws ResourceNotFoundException;
}
