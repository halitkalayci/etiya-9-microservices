package com.etiya.productservice.service;

import com.etiya.productservice.entity.Product;
import com.etiya.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
  private final ProductRepository productRepository;

  @Override
  public void add(Product product) {
    productRepository.save(product);
  }

  @Override
  public List<Product> search(List<UUID> ids) {
    return productRepository.findByIdIn(ids);
  }
}
