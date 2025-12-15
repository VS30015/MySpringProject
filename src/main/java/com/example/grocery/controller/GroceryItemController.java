package com.example.grocery.controller;

import com.example.grocery.entity.GroceryItem;
import com.example.grocery.service.GroceryItemService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/items")
public class GroceryItemController {

    private final GroceryItemService service;

    public GroceryItemController(GroceryItemService service) {
        this.service = service;
    }

    @PostMapping
    public GroceryItem create(@RequestBody GroceryItem item) {
        return service.create(item);
    }

    @GetMapping
    public List<GroceryItem> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GroceryItem get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public GroceryItem update(@PathVariable Long id, @RequestBody GroceryItem item) {
        return service.update(id, item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
