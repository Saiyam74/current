package com.ritrageproductions.registerms.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritrageproductions.registerms.dtos.UserDTO;
import com.ritrageproductions.registerms.models.Login;
import com.ritrageproductions.registerms.models.User;
import com.ritrageproductions.registerms.repositories.LoginRepository;
import com.ritrageproductions.registerms.repositories.UserRepository;
import com.ritrageproductions.registerms.services.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private UserRepository ur;
	@Autowired
	private LoginRepository lr;

	@Override
	public void registerUser(UserDTO user) {
		
		User registeredUser = new User(user.getUsername(), user.getFullname(), user.getAge(), user.getEmail());
		ur.save(registeredUser);
		
		Login loginUser = new Login(user.getUsername(), user.getPassword());
		lr.save(loginUser);
		
	}

}
