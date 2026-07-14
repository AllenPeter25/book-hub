package com.example.inventory_service.service;

import com.example.inventory_service.Entity.Inventory;
import com.example.inventory_service.dto.InventoryRequest;
import com.example.inventory_service.dto.InventoryResponse;
import com.example.inventory_service.errorHandling.BookNotFound;
import com.example.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService{

    public final InventoryRepository repository;

    @Override
    public InventoryResponse create(InventoryRequest request) {
        Inventory inventory = Inventory.builder()
                .bookId(request.getBookId())
                .stock(request.getStock())
                .build();

        Inventory saved = repository.save(inventory);

        return InventoryResponse.builder()
                .bookId(saved.getBookId())
                .stock(saved.getStock())
                .id(saved.getId())
                .build();
    }

    @Override
    public List<InventoryResponse> findAllByBookId(Long id) {
        List<Inventory> allBookById = repository.findByBookId(id);

        return allBookById.stream()
                .map(book -> InventoryResponse.builder()
                        .bookId(book.getBookId())
                        .stock(book.getStock())
                        .id(book.getId())
                        .build()
                ).toList();
    }


    @Override
    public InventoryResponse updateById(Long id, InventoryRequest request) {
        Inventory inventory = repository.findById(id).orElseThrow(() -> new BookNotFound("Not found"));
        inventory.setStock(request.getStock());
        Inventory save = repository.save(inventory);
        return InventoryResponse.builder()
                .id(save.getId())
                .bookId(save.getBookId())
                .stock(save.getStock())
                .build();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
