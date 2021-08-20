package com.thiago.hrpayroll.dtos;

import java.io.Serializable;

import com.thiago.hrpayroll.models.Payment;

public class PaymentDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Double dailyIncome;
	private Integer daysWorked;
	private Double total;
	
	public PaymentDto() {
	}

	public PaymentDto(String name, Double dailyIncome, Integer daysWorked, Double total) {
		this.name = name;
		this.dailyIncome = dailyIncome;
		this.daysWorked = daysWorked;
		this.total = total;
	}
	
	public PaymentDto(Payment payment) {
		this.name = payment.getName();
		this.dailyIncome = payment.getDailyIncome();
		this.daysWorked = payment.getDaysWorked();
		this.total = payment.getTotal();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDailyIncome() {
		return dailyIncome;
	}

	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}

	public Integer getDaysWorked() {
		return daysWorked;
	}

	public void setDaysWorked(Integer daysWorked) {
		this.daysWorked = daysWorked;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	

}
