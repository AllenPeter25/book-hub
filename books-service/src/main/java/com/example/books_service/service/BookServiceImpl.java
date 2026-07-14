package com.example.books_service.service;

import com.example.books_service.client.InventoryClient;
import com.example.books_service.client.ReviewClient;
import com.example.books_service.dto.*;
import com.example.books_service.entity.Book;
import com.example.books_service.exception.BookNotFound;
import com.example.books_service.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    private final InventoryClient inventoryClient;

    private final ReviewClient reviewClient;

    @Override
    public BookResponse createBook(BookRequest request) {
        Book book = Book.builder()
                .title(request.getName())
                .author(request.getAuthor())
                .isbn(request.getIsbn())
                .price(request.getPrice())
                .build();

        Book savedBook = repository.save(book);

        return BookResponse.builder()
                .id(savedBook.getId())
                .title(savedBook.getTitle())
                .author(savedBook.getAuthor())
                .isbn(savedBook.getIsbn())
                .price(savedBook.getPrice())
                .build();
    }

    @Override
    public List<BookResponse> getAllBooks() {
        List<Book> allBooks = repository.findAll();

        return allBooks
                .stream()
                .map(book ->
                        BookResponse.builder()
                                .id(book.getId())
                                .title(book.getTitle())
                                .author(book.getAuthor())
                                .isbn(book.getIsbn())
                                .price(book.getPrice())
                                .build()
                ).toList();
    }

    @Override
    public BookResponse getBookById(Long id) {
        Book book = repository.findById(id).orElseThrow(() -> new BookNotFound("Not present"));
        return BookResponse.builder()
                .id(book.getId())
                .author(book.getAuthor())
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .price(book.getPrice())
                .build();
    }

    @Override
    public BookResponse updateBook(Long id, BookRequest request) {
        Book existingBook = repository.findById(id).orElseThrow(() -> new BookNotFound("Not present"));
        existingBook.setAuthor(request.getAuthor());
        existingBook.setTitle(request.getName());
        existingBook.setPrice(request.getPrice());
        existingBook.setIsbn(request.getIsbn());
        Book savedBook =  repository.save(existingBook);
        return BookResponse.builder()
                .id(savedBook.getId())
                .title(savedBook.getTitle())
                .author(savedBook.getAuthor())
                .price(savedBook.getPrice())
                .isbn(savedBook.getIsbn())
                .build();
    }

    @Override
    public void deleteBook(Long id) {
        Book existingBook = repository.findById(id).orElseThrow(() -> new BookNotFound("Not present"));
        repository.delete(existingBook);
    }

    @Override
    public BookDetailsResponse getBookDetails(Long id) {
        BookResponse book = getBookById(id);

        List<InventoryResponse> inventoryBook = inventoryClient.getBooksById(id);

        List<ReviewResponse> bookReviews = reviewClient.getReviewsById(id);

        return BookDetailsResponse.builder()
                .book(book)
                .reviews(bookReviews)
                .inventory(inventoryBook)
                .build();
    }
}
