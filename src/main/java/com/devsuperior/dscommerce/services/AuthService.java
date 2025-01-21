package com.devsuperior.dscommerce.services;

import org.springframework.stereotype.Service;

import com.devsuperior.dscommerce.entities.User;
import com.devsuperior.dscommerce.services.exceptions.ForbiddenException;

@Service
public class AuthService {

  private UserService userService;

  public AuthService(UserService userService) {
    this.userService = userService;
  }

  public void validateSelfOrAdmin(Long userId) {
    User userLogged = userService.authenticated();
    if (!userLogged.hasRole("ROLE_ADMIN") && !userLogged.getId().equals(userId)) {
      throw new ForbiddenException("Acesso negado");
    }
  }
}