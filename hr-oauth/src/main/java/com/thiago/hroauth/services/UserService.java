package com.thiago.hroauth.services;

import static java.util.Objects.isNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.hroauth.dtos.UserDto;
import com.thiago.hroauth.dtos.UserFetchedDto;
import com.thiago.hroauth.feignclients.UserFeignClient;
import com.thiago.hroauth.models.User;
import com.thiago.hroauth.services.exceptions.ElementNotFoundException;

@Service
public class UserService {
	
	private static Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired 
	UserFeignClient feingClient;
	
	public User fetchUser(UserFetchedDto userFetch) {
		log.info("fecthUser method started");
		
		UserDto userDto = this.feingClient.fetchUser(userFetch).getBody();
		
		if (isNull(userDto)) {
			log.error("Integration error - user not found");
			throw new ElementNotFoundException("Usuário não encontrado");
		}
		
		log.info("fecthUser method finish successful");
		return userMapper(userDto);
	}
	
	private User userMapper(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		return user;
	}
	
}
