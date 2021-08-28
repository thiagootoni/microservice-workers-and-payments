package com.thiago.hruser.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.hruser.dtos.UserDto;
import com.thiago.hruser.repositories.UserRespository;
import com.thiago.hruser.services.exceptions.ElementNotFoundException;

@Service
public class UserService {

	@Autowired
	UserRespository respository;
	
	public UserDto findByEmail(String email) {
		return this.respository.findByEmail(email)
				.map(x -> new UserDto(x))
				.orElseThrow(() -> new ElementNotFoundException("Elemento não encontrado"));
	}

	public List<UserDto> findAll() {
		return this.respository.findAll()
				.stream()
				.map(x -> new UserDto(x))
				.collect(Collectors.toList());
	}
	
	public List<UserDto> searchByEmail(String email){
		if (email.isBlank()) {
			return this.findAll();
		}else {
			return (List.of(this.findByEmail(email)));
		}
	}
	
}
