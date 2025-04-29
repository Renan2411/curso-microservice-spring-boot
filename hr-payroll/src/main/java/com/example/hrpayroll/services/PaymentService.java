package com.example.hrpayroll.services;

import com.example.hrpayroll.entities.Payment;
import com.example.hrpayroll.entities.Worker;
import com.example.hrpayroll.feingclients.WorkerFeingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WorkerFeingClient workerFeingClient;

    @Value("${hr-worker.host}")
    private String workerHost;

    public Payment getPayment(Long workerId, Integer days) {
        Worker worker = workerFeingClient.buscarPorId(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

    public Payment getPaymentRestTemplate(Long workerId, Integer days) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", workerId.toString());

        //Ali na url o {id} será substituido pela sua correspondência no MAP que fizemos
        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);

        Payment payment = new Payment(worker.getName(), worker.getDailyIncome(), days);

        return payment;
    }

}
