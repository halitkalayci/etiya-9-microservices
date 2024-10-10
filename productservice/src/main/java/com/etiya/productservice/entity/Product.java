package com.etiya.productservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
@Entity
public class Product
{
  @Id
  @GeneratedValue
  @UuidGenerator
  private UUID id;

  @Column(name="name")
  private String name;

  @Column(name="units_in_stock")
  private int unitsInStock;

  @Column(name="unit_price")
  private float unitPrice;
}
