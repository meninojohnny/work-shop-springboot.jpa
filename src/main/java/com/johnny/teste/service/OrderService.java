package com.johnny.teste.service;

import com.johnny.teste.entities.Order;
import com.johnny.teste.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    public Order findById(Long orderId) {
        Optional<Order> obj = this.orderRepository.findById(orderId);
        return obj.get();
    }

}
