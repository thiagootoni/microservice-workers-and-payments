package com.thiago.hruser.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thiago.hruser.models.User;

@Repository
public interface UserRespository extends JpaRepository<User, Long>{
	
	//@Query("select User u from User where u.email =: email")
	public Optional<User> findByEmail(String email);

}
