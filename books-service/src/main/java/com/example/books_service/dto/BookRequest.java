package com.example.books_service.dto;

import com.example.books_service.enums.BookCategory;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookRequest {

    @NotBlank(message = "title is required")
    private String name;

    @NotBlank(message = "author is required")
    private String author;

    @NotBlank(message = "isbn is required")
    private String isbn;

    @DecimalMin(value = "0.0", message = "greater than 0", inclusive = false)
    private BigDecimal price;

    @NotNull(message = "required")
    private BookCategory category;
}
