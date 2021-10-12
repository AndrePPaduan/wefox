package com.wefox.wefox.controller;

import com.wefox.wefox.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<?> checkPaymentValidation(){
        paymentService.checkPayment();
        return new ResponseEntity<>("TEST",HttpStatus.OK);
    }
}
