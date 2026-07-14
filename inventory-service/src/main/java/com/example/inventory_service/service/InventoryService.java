package com.example.inventory_service.service;

import com.example.inventory_service.InventoryServiceApplication;
import com.example.inventory_service.dto.InventoryRequest;
import com.example.inventory_service.dto.InventoryResponse;

import java.util.List;

public interface InventoryService {

    InventoryResponse create(InventoryRequest request);

    List<InventoryResponse> findAllByBookId(Long id);

    InventoryResponse updateById(Long id, InventoryRequest request);

    void deleteById(Long id);
}
