package com.gm.controller;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gm.dto.request.SignUpRequest;
import com.gm.entity.Authority;
import com.gm.entity.User;
import com.gm.repository.UserRepository;

@RestController
public class AuthController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/signup")
	public String registerUser(@RequestBody SignUpRequest request) {
		
		if(userRepository.existsById(request.getUsername())) {
			return " Username already exists! ";
		}
		
		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setEnabled(true);
		user.setProvider("JDBC");
		
		Authority authority = new Authority();
		authority.setAuthority(request.getRole());
		authority.setUser(user);
		
		user.setAuthorities(Set.of(authority));
		
		userRepository.save(user);
		return "User Registered Successfully";
		
	}

}
