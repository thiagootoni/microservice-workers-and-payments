package com.thiago.hrworker.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.hrworker.dto.WorkerDTO;
import com.thiago.hrworker.repositories.WorkerRepository;
import com.thiago.hrworker.services.Interfaces.WorkerService;

@Service
public class WorkerServiceImpl implements WorkerService{

	@Autowired
	private WorkerRepository repository;

	@Override
	public List<WorkerDTO> findAll() {
		return this.repository.findAll()
				.stream()
				.map(x -> new WorkerDTO(x))
				.collect(Collectors.toList());
	}

	@Override
	public WorkerDTO findById(Long id) {
		return this.repository.findById(id)
				.map(x -> new WorkerDTO(x))
				.orElseThrow(() -> new ElementNotFoundException("Elemento não encontrado"));
	}
	
	

}
