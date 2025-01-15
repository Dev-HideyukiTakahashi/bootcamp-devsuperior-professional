package com.devsuperior.dscommerce.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.devsuperior.dscommerce.entities.User;

public class UserDTO {

  private Long id;
  private String name;
  private String email;
  private String phone;
  private LocalDate birthDate;
  private List<String> roles = new ArrayList<>();

  public UserDTO(User entity) {
    id = entity.getId();
    name = entity.getName();
    email = entity.getEmail();
    phone = entity.getPhone();
    birthDate = entity.getBirthDate();
    entity.getRoles().forEach(role -> roles.add(role.getAuthority()));
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public List<String> getRoles() {
    return roles;
  }

}
