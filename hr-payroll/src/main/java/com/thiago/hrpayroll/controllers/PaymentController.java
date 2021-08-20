package com.thiago.hrpayroll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiago.hrpayroll.dtos.PaymentDto;
import com.thiago.hrpayroll.models.Payment;
import com.thiago.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {
	
	@Autowired
	PaymentService service;
	
	@GetMapping(value = "/{idWorker}/days/{daysWorked}")
	public ResponseEntity<PaymentDto> getPayement(@PathVariable Long idWorker, @PathVariable Integer daysWorked){
		PaymentDto payment = this.service.getPayment(idWorker, daysWorked);
		return ResponseEntity.ok(payment);
	}
	
	@GetMapping(value = "/{idWorker}/days/{daysWorked}/test")
	public ResponseEntity<Payment> getPayementTest(@PathVariable Long idWorker, @PathVariable Integer daysWorked){
		Payment payment = new Payment("bob", 200.00, daysWorked);
		return ResponseEntity.ok(payment);
	}
	

}
