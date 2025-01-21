package com.devsuperior.dscommerce.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscommerce.dto.OrderDTO;
import com.devsuperior.dscommerce.services.OrderService;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

  private OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  @GetMapping(path = "/{id}")
  public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
    OrderDTO dto = orderService.findById(id);
    return ResponseEntity.ok(dto);
  }

}
