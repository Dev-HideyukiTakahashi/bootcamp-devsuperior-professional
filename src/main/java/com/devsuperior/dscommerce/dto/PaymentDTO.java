package com.devsuperior.dscommerce.dto;

import java.time.Instant;

import com.devsuperior.dscommerce.entities.Payment;

public class PaymentDTO {

  private Long id;
  private Instant moment;

  public PaymentDTO(Long id, Instant moment) {
    this.id = id;
    this.moment = moment;
  }

  public PaymentDTO(Payment entity) {
    id = entity.getId();
    moment = entity.getMoment();
  }

  public Long getId() {
    return id;
  }

  public Instant getMoment() {
    return moment;
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
    PaymentDTO other = (PaymentDTO) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
