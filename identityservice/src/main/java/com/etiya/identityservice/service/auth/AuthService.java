package com.etiya.identityservice.service.auth;

import com.etiya.identityservice.dto.LoginRequest;
import com.etiya.identityservice.dto.RegisterRequest;

public interface AuthService {
  String login(LoginRequest loginRequest);
  String register(RegisterRequest registerRequest);
}
