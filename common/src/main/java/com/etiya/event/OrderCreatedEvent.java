package com.etiya.event;


public class OrderCreatedEvent {

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