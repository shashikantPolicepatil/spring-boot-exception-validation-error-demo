package com.exception.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.demo.dto.UserRequest;
import com.exception.demo.entity.UserEntity;
import com.exception.demo.exception.UserNotFoundException;
import com.exception.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/users/")
	public ResponseEntity<UserEntity> saveUser(@RequestBody @Valid UserRequest userReq) {
		UserEntity saveUser = userService.saveUser(userReq);
		return new ResponseEntity<UserEntity>(saveUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable Integer userId) {
		Optional<UserEntity> userById = userService.getUserById(userId);
		if(userById.isPresent())
			return new ResponseEntity<UserEntity>(userById.get(),HttpStatus.FOUND);
		throw new UserNotFoundException("User Not found");
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserEntity>> getAllUsers() {
		List<UserEntity> allUsers = userService.getAllUsers();
		return new ResponseEntity<List<UserEntity>>(allUsers,HttpStatus.OK); 
	}
}
