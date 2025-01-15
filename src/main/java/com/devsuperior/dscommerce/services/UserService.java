package com.devsuperior.dscommerce.services;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscommerce.dto.UserDTO;
import com.devsuperior.dscommerce.entities.Role;
import com.devsuperior.dscommerce.entities.User;
import com.devsuperior.dscommerce.projections.UserDetailsProjection;
import com.devsuperior.dscommerce.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

  private UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    List<UserDetailsProjection> result = userRepository.searchUserAndRolesByByEmail(username);

    if (result.isEmpty()) {
      throw new UsernameNotFoundException("User not found");
    }

    User user = new User();
    user.setEmail(username);
    user.setPassword(result.get(0).getPassword());
    result.forEach(x -> user.addRole(new Role(x.getRoleId(), x.getAuthority())));
    return user;
  }

  // metodo para retornar dados do usuario autenticado
  // o getClaim() esta na classe AuthorizationServerConfig
  // no metodo tokenCustomizer()
  protected User authenticated() {
    try {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
      String username = jwtPrincipal.getClaim("username");

      return userRepository.findByEmail(username).get();
    } catch (Exception e) {
      throw new UsernameNotFoundException("Email not found");
    }
  }

  @Transactional(readOnly = true)
  public UserDTO getLoggedUser() {
    User user = authenticated();
    return new UserDTO(user);
  }
}