package com.arct.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arct.hrpayroll.entities.Payment;
import com.arct.hrpayroll.entities.Work;
import com.arct.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(long workerId, int days) {
		
		Work worker = workerFeignClient.findId(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
