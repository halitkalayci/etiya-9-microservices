package com.etiya.orderservice.entity;

import com.etiya.orderservice.dto.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "orders")
public class Order
{
  @Id
  private String id;

  private LocalDate orderDate;
  private float totalPrice;
  private List<Product> products;
  private Long customerId;
  private String customerName;
  private String customerSurname;
}
