package com.thiago.hroauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.thiago.hroauth.dtos.UserDto;
import com.thiago.hroauth.dtos.UserFetchedDto;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
@FeignClient(name = "hr-user", path = "/users")
public interface UserFeignClient {
	
	@CircuitBreaker(name = "userClient")
	@PostMapping(value = "/fecth")
	public ResponseEntity<UserDto> fetchUser(@RequestBody UserFetchedDto userFetched);

}
