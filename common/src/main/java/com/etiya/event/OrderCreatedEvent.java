package com.etiya.event;


import java.io.Serializable;

public class OrderCreatedEvent implements Serializable {

  public OrderCreatedEvent() {
  }

  public OrderCreatedEvent(String id) {
    this.id = id;
  }

  private String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
// Pztesi: Identity service test
// Frontend