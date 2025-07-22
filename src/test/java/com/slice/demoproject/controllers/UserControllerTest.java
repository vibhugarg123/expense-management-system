package com.slice.demoproject.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.slice.demoproject.domains.CreateUserRequest;
import com.slice.demoproject.domains.CreateUserResponse;
import com.slice.demoproject.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UserControllerTest {

  @Mock private UserService userService;

  @InjectMocks private UserController userController;

  public UserControllerTest() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void createUser_shouldDelegateToServiceAndReturnResponse() {
    Long userId = 1L;
    CreateUserRequest request = new CreateUserRequest();
    CreateUserResponse expectedResponse = new CreateUserResponse(userId);

    when(userService.addUser(request)).thenReturn(expectedResponse);

    CreateUserResponse actualResponse = userController.createUser(request);

    assertEquals(expectedResponse, actualResponse);
    verify(userService, times(1)).addUser(request);
  }
}
