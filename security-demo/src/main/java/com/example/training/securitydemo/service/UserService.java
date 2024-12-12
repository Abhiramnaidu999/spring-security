package com.example.training.securitydemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.training.securitydemo.model.User;
import com.example.training.securitydemo.repository.UserRepository;

/**
 * Author : Pappula.Naidu
 * Date   : 02-Dec-2024
 * Time   : 5:29:37 pm
 * Project Name :com.example.training.securitydemo.service
 **/
@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private final UserRepository userRepo;
	@Autowired
	private final PasswordEncoder passwordEncoder;
	
	

	//DI using Constructor
	public UserService(UserRepository userRepo, PasswordEncoder passwordEncoder) {
		super();
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}
	
	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepo.save(user); //save() pre-defined method in Jpa repo
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user=userRepo.findByUsername(username);
		return user.orElseThrow(() -> new UsernameNotFoundException("User Not found"));
	}
	
 
 
}
 
