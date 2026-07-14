package com.example.inventory_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InventoryRequest {

    @NotNull(message = "required")
    private Long bookId;

    @NotNull(message = "required")
    private Integer stock;
}
