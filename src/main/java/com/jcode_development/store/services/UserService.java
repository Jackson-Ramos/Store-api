package com.jcode_development.store.services;

import com.jcode_development.store.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
