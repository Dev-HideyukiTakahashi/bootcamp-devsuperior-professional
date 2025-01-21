package com.devsuperior.dscommerce.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscommerce.dto.OrderDTO;
import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.repositories.OrderRepository;
import com.devsuperior.dscommerce.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

  private OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Transactional(readOnly = true)
  public OrderDTO findById(Long id) {
    Order order = orderRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado! Id: " + id));
    return new OrderDTO(order);
  }

}
