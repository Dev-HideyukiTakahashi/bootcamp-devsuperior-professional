package com.devsuperior.dscommerce.entities;

import java.time.Instant;

import com.devsuperior.dscommerce.entities.enums.OrderStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // Config para salvar como um instant no padrão UTC
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant moment;
  private OrderStatus status;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private User client;

  public Order(Long id, Instant moment, OrderStatus status, User client) {
    this.id = id;
    this.moment = moment;
    this.status = status;
    this.client = client;
  }

  public Long getId() {
    return id;
  }

  public Instant getMoment() {
    return moment;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public User getClient() {
    return client;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Order other = (Order) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}