package com.ritrageproductions.registerms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ritrageproductions.registerms.dtos.UserDTO;
import com.ritrageproductions.registerms.services.RegisterService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class MainController {
	
	@Autowired
	private RegisterService rs;
	
	@PostMapping("/signup")
	@ResponseBody
	public String registerUser(@RequestBody UserDTO user) {
		rs.registerUser(user);
		return "data saved";
	}

}
