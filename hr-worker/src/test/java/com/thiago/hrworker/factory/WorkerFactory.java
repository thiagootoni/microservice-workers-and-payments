package com.thiago.hrworker.factory;

import com.thiago.hrworker.dto.WorkerDTO;
import com.thiago.hrworker.models.Worker;

public class WorkerFactory {

	public static Worker createWorker() {
		return new Worker(1L, "Bob", 200.0);
	}
	
	public static Worker createWorker(Long id) {
		return new Worker(id, "Bob", 200.0);
	}
	
	public static WorkerDTO createWorkerDTO() {
		return new WorkerDTO(createWorker());
	}
	
	public static WorkerDTO createWorkerDTO(Long id) {
		return new WorkerDTO(createWorker(id));
	}
}
