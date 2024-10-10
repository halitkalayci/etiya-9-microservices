package com.etiya.orderservice.controller;

import com.etiya.orderservice.dto.CreateOrderRequest;
import com.etiya.orderservice.entity.Order;
import com.etiya.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrdersController
{
  private final OrderService orderService;
  //TODO: Convert all to dto
  @GetMapping()
  public ResponseEntity<List<Order>> getAll() {
    return ResponseEntity.ok(orderService.getAll());
  }

  @PostMapping()
  public ResponseEntity add(@RequestBody CreateOrderRequest orderRequest)
  {
    orderService.add(orderRequest);
    return ResponseEntity.ok("Eklendi");
  }
}
