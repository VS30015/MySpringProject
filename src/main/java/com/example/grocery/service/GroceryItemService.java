package com.example.grocery.service;

import com.example.grocery.entity.GroceryItem;
import com.example.grocery.exception.ResourceNotFoundException;
import com.example.grocery.repository.GroceryItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GroceryItemService {

    private final GroceryItemRepository repo;

    public GroceryItemService(GroceryItemRepository repo) {
        this.repo = repo;
    }

    public GroceryItem create(GroceryItem item) {
        return repo.save(item);
    }

    public List<GroceryItem> getAll() {
        return repo.findAll();
    }

    public GroceryItem getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found"));
    }

    public GroceryItem update(Long id, GroceryItem item) {
        GroceryItem existing = getById(id);
        existing.setName(item.getName());
        existing.setCategory(item.getCategory());
        existing.setPrice(item.getPrice());
        existing.setQuantity(item.getQuantity());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.delete(getById(id));
    }
}
