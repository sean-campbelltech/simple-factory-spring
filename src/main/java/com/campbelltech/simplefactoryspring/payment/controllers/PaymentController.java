package com.campbelltech.simplefactoryspring.payment.controllers;

import com.campbelltech.simplefactoryspring.payment.PaymentService;
import com.campbelltech.simplefactoryspring.payment.PaymentFactory;
import com.campbelltech.simplefactoryspring.payment.dto.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/payments")
public class PaymentController {

    private final PaymentFactory paymentFactory;

    @Autowired
    public PaymentController(PaymentFactory paymentFactory) {
        this.paymentFactory = paymentFactory;
    }

    @PostMapping(path = "/makePayment")
    public ResponseEntity<String> pay(@RequestBody PaymentDto paymentDto) {
        try {
            PaymentService paymentService = paymentFactory.create(paymentDto.paymentMethod);
            return new ResponseEntity<>(paymentService.pay(paymentDto.amount), HttpStatus.OK);
        } catch (ClassNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
