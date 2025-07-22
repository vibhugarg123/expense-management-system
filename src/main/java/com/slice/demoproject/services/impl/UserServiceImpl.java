package com.slice.demoproject.services.impl;

import com.slice.demoproject.domains.CreateUserRequest;
import com.slice.demoproject.domains.CreateUserResponse;
import com.slice.demoproject.entities.User;
import com.slice.demoproject.mappers.UserMapper;
import com.slice.demoproject.repositories.jpa.UserRepository;
import com.slice.demoproject.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;
  private UserMapper userMapper;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  @Override
  public CreateUserResponse addUser(CreateUserRequest request) {
    User user = userMapper.toUser(request);
    Long userId = userRepository.save(user).getId();
    return new CreateUserResponse(userId);
  }
}
