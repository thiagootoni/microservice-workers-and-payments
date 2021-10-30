package com.thiago.hroauth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiago.hroauth.dtos.UserFetchedDto;
import com.thiago.hroauth.models.User;
import com.thiago.hroauth.services.UserService;

@RestController
@RequestMapping(value = "/oauth")
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping(value = "/users/fecth")
	public ResponseEntity<User> fecthUser(@RequestBody UserFetchedDto userFetched){
		User user = this.service.fetchUser(userFetched);		
		return ResponseEntity.ok(user);
	}
	

}
