package com.example.books_service.dto;

import com.example.books_service.enums.BookCategory;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BookResponse {

    private Long id;
    private String title;
    private String author;
    private String isbn;
    private BigDecimal price;
    private BookCategory bookCategory;
}
