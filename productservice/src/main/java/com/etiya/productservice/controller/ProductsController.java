package com.etiya.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/products")
public class ProductsController {
  @GetMapping
  public String get() {
    return "Hello from product service";
  }
}
