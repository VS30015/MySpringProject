package com.example.grocery.service;

import com.example.grocery.entity.Order;
import com.example.grocery.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repo;

    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    public Order create(Order order) {
        return repo.save(order);
    }

    public List<Order> getAll() {
        return repo.findAll();
    }

    public Order getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void delete(Long id) {
        repo.delete(getById(id));
    }
}
