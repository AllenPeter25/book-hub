package com.example.inventory_service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryResponse {

    private Long id;
    private Long bookId;
    private Integer stock;
}
