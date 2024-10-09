package com.etiya.productservice.controller;

import io.github.halitkalayci.ExampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/products")
public class ProductsController {
  @GetMapping
  public String get() {
    ExampleService exampleService = new ExampleService();
    return exampleService.hello();
  }
}
