package com.saiyam.login.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saiyam.login.models.Login;
import com.saiyam.login.repositories.LoginRepository;
import com.saiyam.login.services.LoginService;

@Service
public class Loginserviceimpl implements LoginService {

	@Autowired
	private LoginRepository lr;
	@Override
	public String checkuser(Login login) {
		// TODO Auto-generated method stub
		if(lr.existsById(login.getUsername())){
			for(Login user:lr.findAll()) {
				if(user.getUsername().equals(login.getUsername() ) && user.getPassword().equals(login.getPassword()) ) {
					System.out.println("user logged in");
					return "User Logged in";
				}
			}
		}
		return "Login Failed";
	}

}
