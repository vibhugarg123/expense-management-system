package com.slice.demoproject.mappers;

import com.slice.demoproject.domains.CreateUserRequest;
import com.slice.demoproject.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  User toUser(CreateUserRequest request);
}
