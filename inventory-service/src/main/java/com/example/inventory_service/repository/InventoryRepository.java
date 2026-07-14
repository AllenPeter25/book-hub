package com.example.inventory_service.repository;

import com.example.inventory_service.Entity.Inventory;
import com.example.inventory_service.dto.InventoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    List<Inventory> findByBookId(Long id);
}
