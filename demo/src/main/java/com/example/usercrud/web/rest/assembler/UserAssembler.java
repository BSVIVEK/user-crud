package com.example.usercrud.web.rest.assembler;

import com.example.usercrud.web.rest.UserDto;
import com.example.usercrud.web.rest.resource.UserResource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

@Component
public class UserAssembler {

  /**
   * This method converts user resource to user dto
   */
  public UserDto toUserCreationDto(UserResource userResource) {
    UserDto userDto = new UserDto();
    if (userResource != null) {
      BeanUtils.copyProperties(userResource, userDto);
      if (StringUtils.isNotEmpty(userResource.getUsername())) {
        userDto.setUserName(userResource.getUsername().toLowerCase(Locale.ENGLISH));
      }
      if (StringUtils.isNotEmpty(userResource.getEmail())) {
        userDto.setEmail(userResource.getEmail().toLowerCase(Locale.ENGLISH));
      }
    }
    return userDto;
  }
}
