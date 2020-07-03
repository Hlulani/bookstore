package com.bookstore.service.impl;

import com.bookstore.dto.BookDto;
import com.bookstore.exception.ResourceNotFoundException;
import com.bookstore.model.Author;
import com.bookstore.model.Book;
import com.bookstore.repository.BookStoreRepository;
import com.bookstore.service.BookStoreService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("BookStoreService")
public class BookStoreServiceImpl implements BookStoreService {

    private BookStoreRepository bookStoreRepository;

    public BookStoreServiceImpl(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    @Override
    public BookDto createBooks(BookDto bookDto) {

        Author author = Author.builder()
                .authorNames("")
                .build();

        Book book = Book.builder()
                .id(bookDto.getId())
                .author(bookDto.getAuthor())
                .name(bookDto.getName())
                .price(bookDto.getPrice())
                .year(bookDto.getYear())
                .author(bookDto.getAuthor())
//                .authorList(Arrays.asList(author))
                .build();

        bookStoreRepository.save(book);
        bookDto.setId(book.getId());
        bookDto.setAuthor(book.getAuthor());
        return bookDto;
    }

    @Override
    public Book updateBooks(long bookId, Book bookDetails) throws ResourceNotFoundException {

        Book book = bookStoreRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book for this id :: " + bookId + " Not found"));

        book.setAuthor(bookDetails.getAuthor());
        book.setName(bookDetails.getName());
        book.setPrice(bookDetails.getPrice());
        book.setYear(bookDetails.getYear());

        final Book updateBook = bookStoreRepository.save(book);

        return updateBook;
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> bookList = bookStoreRepository.findAll();

        return bookList.stream().map(book -> BookDto.builder()
                .id(book.getId())
                .author(book.getAuthor())
                .name(book.getName())
                .price(book.getPrice())
                .year(book.getYear())
                .build()).collect(Collectors.toList());
    }

    @Override
    public Book getBookById(long bookId) throws ResourceNotFoundException {
        Book book = bookStoreRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book for this id :: " + bookId + " Not found"));
        return book;
    }

    @Override
    public Map<String, Boolean> deleteBook(long bookId) throws ResourceNotFoundException {
        Book book = bookStoreRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book for this id :: " + bookId + " Not found"));
        bookStoreRepository.delete(book);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
