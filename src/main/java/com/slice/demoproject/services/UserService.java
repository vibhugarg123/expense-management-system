package com.slice.demoproject.services;

import com.slice.demoproject.domains.CreateUserRequest;
import com.slice.demoproject.domains.CreateUserResponse;

public interface UserService {
  CreateUserResponse addUser(CreateUserRequest request);
}
