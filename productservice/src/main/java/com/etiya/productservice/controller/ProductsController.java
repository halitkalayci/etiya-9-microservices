package com.etiya.productservice.controller;

import com.etiya.productservice.entity.Product;
import com.etiya.productservice.service.ProductService;
import io.github.halitkalayci.ExampleService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductsController {
  private final ProductService productService;
  @PostMapping
  public ResponseEntity<String> add(@RequestBody Product product) {
    productService.add(product);
    return ResponseEntity.ok("Eklendi");
  }

  @PostMapping("search")
  public List<Product> getByIds(@RequestBody List<UUID> ids)
  {
    return productService.search(ids);
  }
}
