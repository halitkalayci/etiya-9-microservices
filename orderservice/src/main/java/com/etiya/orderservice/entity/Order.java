package com.etiya.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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
  private UUID customerId;
  private String customerName;
  private String customerSurname;
}
