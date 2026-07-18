package com.example.books_service.service;

import com.example.books_service.dto.BookDetailsResponse;
import com.example.books_service.dto.BookRequest;
import com.example.books_service.dto.BookResponse;
import com.example.books_service.enums.BookCategory;

import java.util.List;

public interface BookService {

    BookResponse createBook(BookRequest request);

    List<BookResponse> getAllBooks();

    BookResponse getBookById(Long id);

    BookResponse updateBook(Long id, BookRequest request);

    void deleteBook(Long Id);

    BookDetailsResponse getBookDetails(Long id);

    List<BookResponse> getBooksByAuthor(String author);

    List<BookResponse> querySearch(String author, String title, BookCategory category);
}
