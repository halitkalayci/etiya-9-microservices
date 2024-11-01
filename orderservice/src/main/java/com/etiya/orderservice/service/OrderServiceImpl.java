package com.etiya.orderservice.service;

import com.etiya.event.OrderCreatedEvent;
import com.etiya.orderservice.client.ProductServiceClient;
import com.etiya.orderservice.dto.CreateOrderRequest;
import com.etiya.orderservice.dto.ProductForOrderDto;
import com.etiya.orderservice.entity.Order;
import com.etiya.orderservice.entity.Product;
import com.etiya.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService{
  private final OrderRepository orderRepository;
  private final ProductServiceClient productServiceClient;
  private final StreamBridge streamBridge;
  @Override
  public List<Order> getAll() {
    return orderRepository.findAll();
  }

  @Override
  public void add(CreateOrderRequest createOrderRequest) {
    // Customer bilgileri


    List<Product> response = new ArrayList<>();

    //TODO: Refactor as business rules.
    // OrderBusinessRules.AllProductsShouldExist()

    // 293 -> 5 adet istenmiş stok yeterli mi?
    Order order = new Order();
    order.setOrderDate(LocalDate.now());
    order.setCustomerId(createOrderRequest.getCustomerId());
    order.setProducts(response);
    //orderRepository.save(order); // Sipariş alındı.

    // Diğer 5 servis bir işlem yapacak..
    // Kafka -> NewOrderCreated -> { id:1, customerId:2, products:[] }
    // Subscriber-(Consumer) -> NewOrderCreated kafkada ne zaman oluşturulsa ben onu alıp işlicem.
    OrderCreatedEvent event = new OrderCreatedEvent(order.getId());
    streamBridge.send("sendEvent-out-0", event); // 'sendEvent-out-0' çıkış kanalı üzerinden gönder
  }
}
