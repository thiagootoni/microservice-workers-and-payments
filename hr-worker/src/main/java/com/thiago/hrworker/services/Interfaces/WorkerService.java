package com.thiago.hrworker.services.Interfaces;

import java.util.List;

import com.thiago.hrworker.dto.WorkerDTO;

public interface WorkerService {
	
	public List<WorkerDTO> findAll();
	
	public WorkerDTO findById(Long id);

}
