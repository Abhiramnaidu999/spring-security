package com.example.training.securitydemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.training.securitydemo.model.User;

/**
* Author : Pappula.Naidu
* Date   : 02-Dec-2024
* Time   : 5:22:49 pm
* Project Name :com.example.training.securitydemo.repository
**/
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);
}
