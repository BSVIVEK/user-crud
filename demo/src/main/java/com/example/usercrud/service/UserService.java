package com.example.usercrud.service;

import com.example.usercrud.domain.User;
import com.example.usercrud.web.rest.UserDto;
import com.example.usercrud.web.rest.resource.UserResponseResource;

public interface UserService {

  UserResponseResource createUser(UserDto userDto);

  UserResponseResource getUserByEmailOrUserName(String EmailOrUserName);

//  UserResponseResource getUserByUserName(String userName, User user);
}
