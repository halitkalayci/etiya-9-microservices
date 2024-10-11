package com.etiya.identityservice.service.user;

import com.etiya.identityservice.entity.User;
import com.etiya.identityservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
  private final UserRepository userRepository;
  @Override
  public User create(User user) {
    userRepository.save(user);
    return user;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByEmailIgnoreCase(username)
            .orElseThrow(() -> new UsernameNotFoundException(""));
  }
}