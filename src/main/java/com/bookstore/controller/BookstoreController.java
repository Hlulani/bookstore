package com.bookstore.controller;

import com.bookstore.dto.BookDto;
import com.bookstore.exception.ResourceNotFoundException;
import com.bookstore.model.Book;
import com.bookstore.service.BookStoreService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.bookstore.controller.BookstoreController.BOOK_BASE_URL;

@RestController
@RequestMapping(BOOK_BASE_URL)
public class BookstoreController {

    public static final String BOOK_BASE_URL ="/api/books";

    private BookStoreService bookStoreService;

    public BookstoreController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    @PostMapping
//    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseStatus(value = HttpStatus.CREATED)
    public BookDto createBooks(@RequestBody BookDto book) {
        return bookStoreService.createBooks(book);
    }

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookStoreService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Book getBookById(@PathVariable(value = "id") long bookId) throws ResourceNotFoundException {
        return  bookStoreService.getBookById(bookId);
    }

   @PutMapping("/book/{id}")
   @CrossOrigin(origins = "http://localhost:4200")
   public Book updateBooks(@PathVariable(value = "id") long bookId, @RequestBody Book bookDetails) throws ResourceNotFoundException {
        return bookStoreService.updateBooks(bookId, bookDetails);
   }

    @DeleteMapping("/book/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Map<String, Boolean> deleteBook(@PathVariable(value = "id") long bookId) throws ResourceNotFoundException {
        return bookStoreService.deleteBook(bookId);
    }

}