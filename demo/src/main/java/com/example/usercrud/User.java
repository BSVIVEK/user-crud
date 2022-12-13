package com.example.usercrud;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usercrud")
public class User {

  @Id
//  @Column(name = "id")
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String email;
  private String uname;

  public User() {

  }

  public User(Long id, String uname, String email) {
    this.id = id;
    this.uname = uname;
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUname() {
    return uname;
  }

  public void setUname(String uname) {
    this.uname = uname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", uname='" + uname + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
