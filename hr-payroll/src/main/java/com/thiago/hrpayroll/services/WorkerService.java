package com.thiago.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.thiago.hrpayroll.feignclients.WorkerFeignClient;
import com.thiago.hrpayroll.models.Worker;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class WorkerService {
	
	@Autowired
	RestTemplate restTemplate;
	
	/*
	@Value("${hr-worker.host}")
	private String workerHost;
	*/
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	@CircuitBreaker(name = "workerClient")
	public Worker findByid(Long idWorker) {
		
		/*
		 * Chamada via Rest Template
		
		String uri = workerHost.concat("/workers/{id}");
		
		Map<String, String> parameters = new HashMap<>();
		parameters.put("id", idWorker.toString());
		
		Worker worker = restTemplate.getForObject(uri, Worker.class, parameters);
		
		return worker;
		*/
		
		Worker worker = workerFeignClient.findById(idWorker).getBody();
		return worker;
	}

}
