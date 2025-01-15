package com.devsuperior.dscommerce.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscommerce.dto.UserDTO;
import com.devsuperior.dscommerce.services.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {

  private UserService userService;

  public UserController(UserService UserService) {
    this.userService = UserService;
  }

  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
  @GetMapping(path = "/me")
  public ResponseEntity<UserDTO> getLoggedUser() {
    UserDTO dto = userService.getLoggedUser();
    return ResponseEntity.ok(dto);
  }

}
