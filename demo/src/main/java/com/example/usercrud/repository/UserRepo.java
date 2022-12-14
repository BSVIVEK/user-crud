package com.example.usercrud.repository;

import com.example.usercrud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Long> {

  //@Query(value = "select email from user_crud where email = ?1", nativeQuery = true);

//  User findByEmailId(String emailId);

  User findByEmail(String emailId);

  User findByUsername(String userName);

//  User findUserByEmailExists(String emailId);

}
