package com.example.hrpayroll.services;

import com.example.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, Integer days){
        Payment payment = new Payment("Renan", 100.50, days);

        return payment;
    }

}
