package com.saiyam.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.saiyam.login.models.Login;
import com.saiyam.login.services.LoginService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class MainController {
	
	@Autowired
	private LoginService ls;
	
	@PostMapping("/login")
	@ResponseBody
	public String Signin(@RequestBody Login login) {
		return ls.checkuser(login);
		
	}
}
