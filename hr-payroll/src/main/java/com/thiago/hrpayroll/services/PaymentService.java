package com.thiago.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.hrpayroll.dtos.PaymentDto;
import com.thiago.hrpayroll.models.Payment;
import com.thiago.hrpayroll.models.Worker;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerService workerService;
	
	
	public PaymentDto getPayment(Long idWorker, Integer daysWorked) {
		//return new PaymentDto(new Payment("Bob", 200.0, daysWorked));
		
		Worker worker = workerService.findByid(idWorker);
		return new PaymentDto(new Payment(worker, daysWorked));
		
	};

}
