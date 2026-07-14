package com.example.inventory_service.controller;

import com.example.inventory_service.dto.InventoryRequest;
import com.example.inventory_service.dto.InventoryResponse;
import com.example.inventory_service.service.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventory;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryResponse create(@Valid @RequestBody InventoryRequest request) {
        return inventory.create(request);
    }

    @GetMapping("/book/{id}")
    public List<InventoryResponse> findById(@PathVariable Long id) {
        return inventory.findAllByBookId(id);
    }

    @PatchMapping("/book/{id}")
    public InventoryResponse update(@PathVariable Long id, @RequestBody InventoryRequest request) {
        return inventory.updateById(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        inventory.deleteById(id);
    }
}
