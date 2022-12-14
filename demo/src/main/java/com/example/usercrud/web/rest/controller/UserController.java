package com.example.usercrud.web.rest.controller;

import com.example.usercrud.service.UserService;
import com.example.usercrud.web.rest.assembler.UserAssembler;
import com.example.usercrud.web.rest.resource.UserResource;
import com.example.usercrud.web.rest.resource.UserResponseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping({"/test/"})
public class UserController {

  @Autowired
  private UserAssembler userAssembler;

  @Autowired
  private UserService userService;


  /**
   * Create user
   */
  @PostMapping(value = "create")
  public ResponseEntity<UserResponseResource> createUser(
      @RequestBody UserResource userResource) {
    return new ResponseEntity<>(userService.createUser(userAssembler.toUserCreationDto(userResource)), HttpStatus.CREATED);
  }

  /**
   * Get user
   */
  @GetMapping(value = "users/{user}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<UserResponseResource> fetchUser(
      @PathVariable String user) {
    return new ResponseEntity<>(userService.getUserByEmailOrUserName(user), HttpStatus.OK);
  }



}
