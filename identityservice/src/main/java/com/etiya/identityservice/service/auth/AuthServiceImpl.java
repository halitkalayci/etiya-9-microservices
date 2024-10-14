package com.etiya.identityservice.service.auth;

import com.etiya.identityservice.dto.LoginRequest;
import com.etiya.identityservice.dto.RegisterRequest;
import com.etiya.identityservice.entity.User;
import com.etiya.identityservice.service.user.UserService;
import io.github.halitkalayci.security.BaseJwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService
{
  private final PasswordEncoder passwordEncoder;
  //private final BaseJwtService jwtService; // Ortak bi noktadan almak.
  // Core paketindeki Bean
  // 10.30
  private final UserService userService;
  private final BaseJwtService baseJwtService;

  @Override
  public String login(LoginRequest loginRequest) {
    UserDetails user = userService.loadUserByUsername(loginRequest.getEmail());
    boolean passwordMatching = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
    if(!passwordMatching)
      throw new RuntimeException("E-posta veya şifre hatalı.");

    return baseJwtService.generateToken(user.getUsername());
  }

  @Override
  public String register(RegisterRequest registerRequest) {
    User userToAdd =new User();
    userToAdd.setEmail(registerRequest.getEmail());
    userToAdd.setName(registerRequest.getName());
    userToAdd.setSurname(registerRequest.getSurname());
    userToAdd.setIdentityNo(registerRequest.getIdentityNo());
    userToAdd.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
    User user = userService.create(userToAdd);
    return baseJwtService.generateToken(user.getUsername());
  }
}