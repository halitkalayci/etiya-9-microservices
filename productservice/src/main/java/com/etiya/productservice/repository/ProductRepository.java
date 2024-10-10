package com.etiya.productservice.repository;

import com.etiya.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
  List<Product> findByIdIn(List<UUID> ids);
}
