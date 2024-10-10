package com.etiya.orderservice.service;

import com.etiya.orderservice.entity.Order;

import java.util.List;

public interface OrderService
{
  List<Order> getAll();
  void add(Order order);
}
