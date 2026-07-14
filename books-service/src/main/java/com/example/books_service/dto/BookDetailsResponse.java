package com.example.books_service.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BookDetailsResponse {

    private BookResponse book;

    private List<InventoryResponse> inventory;

    private List<ReviewResponse> reviews;

}
