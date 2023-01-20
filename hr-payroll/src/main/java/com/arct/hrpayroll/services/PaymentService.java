package com.arct.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.arct.hrpayroll.entities.Payment;
import com.arct.hrpayroll.entities.Work;

@Service
public class PaymentService {
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;

	public Payment getPayment(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", ""+workerId);
		
		Work worker = restTemplate.getForObject(workerHost + "/workers/{id}", Work.class, uriVariables);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
