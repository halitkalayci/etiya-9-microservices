package com.etiya.customerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/customers")
public class CustomersController {
  @GetMapping
  public String get() {
    System.out.println("İstek geldi ve işleniyor..");
    return "Hello from customer service";
  }
}
