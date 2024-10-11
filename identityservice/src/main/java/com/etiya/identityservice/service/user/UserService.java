package com.etiya.identityservice.service.user;


import com.etiya.identityservice.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
  User create(User user);
}
