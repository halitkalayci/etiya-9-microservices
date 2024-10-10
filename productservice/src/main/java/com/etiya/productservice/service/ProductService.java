package com.etiya.productservice.service;

import com.etiya.productservice.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
  void add(Product product);
  List<Product> search(List<UUID> ids);
}
