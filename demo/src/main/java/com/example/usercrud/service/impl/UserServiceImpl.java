package com.example.usercrud.service.impl;

import org.apache.commons.validator.routines.EmailValidator;

import com.example.usercrud.domain.User;
import com.example.usercrud.repository.UserRepo;
import com.example.usercrud.service.UserService;
import com.example.usercrud.utils.UserManagementUtil;
import com.example.usercrud.web.rest.UserDto;
import com.example.usercrud.web.rest.resource.UserResponseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;
import javax.validation.constraints.Email;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepo userRepo;

//  @Autowired
//  UserResponseResource responseResource;

  @Override
  public UserResponseResource createUser(UserDto userDto) {
    Integer age;

    User user = checkAndCreateUser(userDto);
    age = LocalDate.now().getYear() - Integer.parseInt(userDto.getDateOfBirth().substring(6));
    user.setAge(age);
    user.setId(new Long(randomNum()));
    userRepo.save(user);

    user = userRepo.findByEmail(userDto.getEmail());
    UserResponseResource userResponseResource = new UserResponseResource();
    userResponseResource.setId(user.getId());
    userResponseResource.setAge(user.getAge());
    userResponseResource.setEmail(user.getEmail());

    return new UserResponseResource();
  }

  public UserResponseResource getUserByEmailOrUserName(String emailOrUserName) {
    User user = null;
    if (EmailValidator.getInstance().isValid(emailOrUserName)) {
      user = checkAndCreateUserByEmail(emailOrUserName);
    } else {
      user = checkAndCreateUser(emailOrUserName);
    }
    return UserManagementUtil.constructUserResponse(Optional.ofNullable(user), user);
  }


  private User checkAndCreateUser(UserDto userDto) {
    User user = userRepo.findByEmail(userDto.getEmail());
    return UserManagementUtil.constructUserEntity(Optional.ofNullable(user), userDto);
  }

  private User checkAndCreateUser(String userName) {
    return userRepo.findByUsername(userName);
  }

  private User checkAndCreateUserByEmail(String email) {
    return userRepo.findByEmail(email);
  }

  public static int randomNum() {
    Random r = new Random( System.currentTimeMillis() );
    return 10000 + r.nextInt(20000);
  }



}
