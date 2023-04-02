package com.exception.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.demo.dto.UserRequest;
import com.exception.demo.entity.UserEntity;
import com.exception.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public UserEntity saveUser(UserRequest userReq) {
		UserEntity user = new UserEntity(0, userReq.getAge(), userReq.getName(),
				userReq.getEmail(),userReq.getMobileNumber(), userReq.getNationality());
		UserEntity save = userRepo.save(user);
		return save;
	}

	public List<UserEntity> getAllUsers() {
		return userRepo.findAll();
	}

	public Optional<UserEntity> getUserById(Integer id) {
		return userRepo.findById(id);
	}
}
