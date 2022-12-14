package com.example.usercrud.web.rest.resource;

import lombok.Data;

@Data
public class UserResponseResource {
  private Long id;
  private String email;
  private Integer age;
}
