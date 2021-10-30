package com.thiago.hruser.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thiago.hruser.dtos.UserDto;
import com.thiago.hruser.dtos.UserFetchedDto;
import com.thiago.hruser.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	UserService service;

	@GetMapping(value = "/search")
	public ResponseEntity<List<UserDto>> findByEmail(@RequestParam String email) {

		return ResponseEntity.ok(this.service.searchByEmail(email));
	}
	
	@PostMapping(value = "/fetch")
	public ResponseEntity<UserDto> fetchUser(@RequestBody UserFetchedDto userFetched) {

		return ResponseEntity.ok(this.service.findByEmail(userFetched.getEmail()));
	}
}
