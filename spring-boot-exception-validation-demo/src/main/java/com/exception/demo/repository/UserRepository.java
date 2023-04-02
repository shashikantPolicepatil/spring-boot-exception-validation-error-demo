package com.exception.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exception.demo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
