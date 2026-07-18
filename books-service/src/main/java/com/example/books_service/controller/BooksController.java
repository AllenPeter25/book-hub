package com.example.books_service.controller;

import com.example.books_service.dto.BookDetailsResponse;
import com.example.books_service.dto.BookRequest;
import com.example.books_service.dto.BookResponse;
import com.example.books_service.enums.BookCategory;
import com.example.books_service.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

    private final BookService bookService;

    @PostMapping
    public BookResponse createBook(@Valid @RequestBody BookRequest request) {
        return bookService.createBook(request);
    }

    @GetMapping
    public List<BookResponse> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping ("/{id}")
    BookResponse getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    BookResponse ReplaceById(@PathVariable Long id, @Valid @RequestBody BookRequest request) {
        return bookService.updateBook(id, request);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/{id}/details")
    public BookDetailsResponse getBookDetails(@PathVariable Long id) {
        return bookService.getBookDetails(id);
    }

    @GetMapping("/author/{author}")
    public List<BookResponse> getBookByAuthor(@PathVariable String author) {
        return bookService.getBooksByAuthor(author);
    }

    @GetMapping("/search")
    public List<BookResponse> searchBooks(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) BookCategory category
    ) {
        return bookService.querySearch(author, title, category);
    }
}
