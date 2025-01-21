package com.devsuperior.dscommerce.services;

import java.time.Instant;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscommerce.dto.OrderDTO;
import com.devsuperior.dscommerce.dto.OrderItemDTO;
import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderItem;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.entities.enums.OrderStatus;
import com.devsuperior.dscommerce.repositories.OrderItemRepository;
import com.devsuperior.dscommerce.repositories.OrderRepository;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import com.devsuperior.dscommerce.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

  private OrderRepository orderRepository;
  private UserService userService;
  private ProductRepository productRepository;
  private OrderItemRepository orderItemRepository;

  public OrderService(OrderRepository orderRepository, UserService userService, ProductRepository productRepository,
      OrderItemRepository orderItemRepository) {
    this.orderRepository = orderRepository;
    this.userService = userService;
    this.productRepository = productRepository;
    this.orderItemRepository = orderItemRepository;
  }

  @Transactional(readOnly = true)
  public OrderDTO findById(Long id) {
    Order order = orderRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado! Id: " + id));
    return new OrderDTO(order);
  }

  @Transactional
  public OrderDTO insert(OrderDTO dto) {

    Order order = new Order();
    order.setMoment(Instant.now());
    order.setStatus(OrderStatus.WAITING_PAYMENT);
    order.setClient(userService.authenticated());

    for (OrderItemDTO itemDTO : dto.getItems()) {
      Product product = productRepository.getReferenceById(itemDTO.getProductId());
      OrderItem item = new OrderItem(order, product, itemDTO.getQuantity(), product.getPrice());
      order.getItems().add(item);
    }

    orderRepository.save(order);
    orderItemRepository.saveAll(order.getItems());

    return new OrderDTO(order);
  }

}
