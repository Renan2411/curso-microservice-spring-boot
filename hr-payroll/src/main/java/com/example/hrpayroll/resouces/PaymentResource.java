package com.example.hrpayroll.resouces;

import com.example.hrpayroll.entities.Payment;
import com.example.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{id}/days/{days}")
    public ResponseEntity<Payment> buscarPayment(@PathVariable("id") Long workerId, @PathVariable Integer days) {
        Payment payment = paymentService.getPayment(workerId, days);

        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

}
