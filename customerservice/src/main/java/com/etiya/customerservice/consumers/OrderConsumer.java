package com.etiya.customerservice.consumers;

import com.etiya.event.OrderCreatedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class OrderConsumer {
  @Bean
  public Consumer<OrderCreatedEvent> processOrderEvent()
  {
    return event -> {
      System.out.println("Yeni bir sipariş oluşturulma mesajı stream'den alındı:" + event.getId());
    };
  }
}
