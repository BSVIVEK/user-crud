package com.example.usercrud.utils;

import com.example.usercrud.domain.User;
import com.example.usercrud.web.rest.UserDto;
import com.example.usercrud.web.rest.resource.UserResponseResource;

import java.util.Optional;

public class UserManagementUtil {


  /**
   * create user
   */
  public static User constructUserEntity(Optional<User> optionalUser, UserDto userDto) {
    User user = null;
    if (optionalUser.isPresent()) {
      user = optionalUser.get();
    } else {
      user = new User();
      user.setUsername(userDto.getUserName());
      user.setEmail(userDto.getEmail());
    }
    return user;
  }

  /**
   * create user response resource
   */
  public static UserResponseResource constructUserResponse(Optional<User> optionalUser, User user) {
    UserResponseResource userResponseResource = null;
    if (optionalUser.isPresent()) {
      userResponseResource = new UserResponseResource();
      userResponseResource.setId(user.getId());
      userResponseResource.setAge(user.getAge());
      userResponseResource.setEmail(user.getEmail());
    }
    return userResponseResource;
  }

}
