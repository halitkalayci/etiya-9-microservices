package com.etiya.orderservice.repository;

import com.etiya.orderservice.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String>
{
  // Klasik repository kuralları geçerli
  Order findByTotalPrice(float totalPrice);
}
