package com.example.books_service.client;

import com.example.books_service.dto.InventoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "inventory-service")
public interface InventoryClient {

    @GetMapping("/inventory/book/{id}")
    List<InventoryResponse> getBooksById(@PathVariable Long id);
}
