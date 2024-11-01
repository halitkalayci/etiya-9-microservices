package com.etiya.orderservice.stream;

import com.etiya.event.OrderCreatedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.function.Consumer;
import java.util.function.Supplier;

@Configuration
public class EventProcessor {


  @Bean
  public Supplier<Message<OrderCreatedEvent>> sendEvent() {
    return () -> {
      OrderCreatedEvent event = new OrderCreatedEvent();
      event.setId("12345");
      return MessageBuilder.withPayload(event).build();
    };
  }

  @Bean
  public Consumer<OrderCreatedEvent> processEvent() {
    return event -> {
      System.out.println("Received event: " + event);
    };
  }

}
