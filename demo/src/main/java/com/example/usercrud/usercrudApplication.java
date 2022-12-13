package com.example.usercrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class usercrudApplication {

	@Autowired
	UserRepo userRepo;

	@GetMapping("/test")
	public String test() {
		User user = new User(343434L, "Ram", "morevcom");
		userRepo.save(user);

		return userRepo.findAll().stream().findFirst().toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(usercrudApplication.class, args);
	}

}
