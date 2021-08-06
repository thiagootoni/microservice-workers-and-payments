package com.thiago.hrworker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thiago.hrworker.dto.WorkerDTO;
import com.thiago.hrworker.services.Interfaces.WorkerService;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {
	
	@Autowired
	WorkerService service;

	@GetMapping
	public ResponseEntity<List<WorkerDTO>> findAll(){
		List<WorkerDTO> workers = this.service.findAll();
		return ResponseEntity.ok().body(workers);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<WorkerDTO> findById(@PathVariable Long id){
		WorkerDTO worker = this.service.findById(id);
		return ResponseEntity.ok().body(worker);		
	}
	
}
