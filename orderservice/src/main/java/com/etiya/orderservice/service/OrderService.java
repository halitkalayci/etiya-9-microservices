package com.etiya.orderservice.service;

import com.etiya.orderservice.dto.CreateOrderRequest;
import com.etiya.orderservice.entity.Order;

import java.util.List;

public interface OrderService
{
  List<Order> getAll();
  void add(CreateOrderRequest createOrderRequest);
}
