package com.slice.demoproject.controllers;

import com.slice.demoproject.domains.CreateUserRequest;
import com.slice.demoproject.domains.CreateUserResponse;
import com.slice.demoproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
    return userService.addUser(request);
  }
}
