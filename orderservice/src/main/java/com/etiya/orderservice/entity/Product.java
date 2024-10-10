package com.etiya.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product
{
  private UUID id;
  private String name;
  private int unitsInStock;
  private float unitPrice;
}
