package com.etiya.orderservice.service;

import com.etiya.orderservice.entity.Order;
import com.etiya.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService{
  private final OrderRepository orderRepository;
  @Override
  public List<Order> getAll() {
    return orderRepository.findAll();
  }

  @Override
  public void add(Order order) {
    // ürün bilgileri ve customer bilgilerini ilgili servislerden iletişim yolu ile almak..

    // Sync iletişim
    orderRepository.save(order);
  }
}
