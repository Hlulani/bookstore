package com.bookstore.impl;

import com.bookstore.dto.BookDto;
import com.bookstore.exception.ResourceNotFoundException;
import com.bookstore.model.Book;
import com.bookstore.repository.BookStoreRepository;
import com.bookstore.service.impl.BookStoreServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookStoreServiceImplTest {

        @InjectMocks
        BookStoreServiceImpl bookStoreService;

        @Mock
        private BookStoreRepository bookStoreRepository;

        @BeforeEach
        void setUp() {
            MockitoAnnotations.initMocks(this);
        }

        @Test
        void shouldCreateBooksTest() {

            Book book = Book.builder()
                    .author("Hlulani")
                    .name("Springboot")
                    .price(250)
                    .year("20202")
                    .build();

            BookDto bookDto = BookDto.builder()
                    .author("Hlulani")
                    .name("Springboot")
                    .price(250)
                    .year("20202")
                    .build();

            when(bookStoreRepository.save(book)).thenReturn(book);

            BookDto bookDto1 = bookStoreService.createBooks(bookDto);

            assertEquals("Hlulani", bookDto1.getAuthor());
        }

        @Test
        void shouldGetAllBooks() {
            Book book = Book.builder()
                    .author("Hlulani")
                    .name("Springboot")
                    .price(250)
                    .year("20202")
                    .build();

            when(bookStoreRepository.findAll()).thenReturn(Arrays.asList(book));
            List<BookDto> bookDtos = bookStoreService.getAllBooks();
            assertNotNull(bookDtos);
        }

        @Test
        void shouldUpdateBooks() throws ResourceNotFoundException {
            Book book = Book.builder()
                    .id(1L)
                    .author("Hlulani")
                    .name("Springboot")
                    .price(250)
                    .year("20202")
                    .build();

            when(bookStoreRepository.save(book)).thenReturn(book);
            ResourceNotFoundException resourceNotFoundException = Assertions.assertThrows(ResourceNotFoundException.class, () ->
                    bookStoreService.updateBooks(1L, book));

            assertEquals("Book for this id :: 1 Not found", resourceNotFoundException.getMessage());
        }
}
