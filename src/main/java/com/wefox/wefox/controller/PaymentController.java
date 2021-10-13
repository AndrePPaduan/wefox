package com.wefox.wefox.controller;

import com.wefox.wefox.model.Payment;
import com.wefox.wefox.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<?> checkPaymentValidation(@RequestBody Payment payment) throws IOException {

        if (paymentService.checkPayment(payment)) {
            System.out.println("111");
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } else {
            System.out.println("2");

            return new ResponseEntity<>("Error validating, please check the logs", HttpStatus.EXPECTATION_FAILED);
        }
    }

    @KafkaListener(topics = "online",
            groupId = "wefox")
    ResponseEntity<?> listenerOnline(Payment payment) throws IOException {
        if (paymentService.checkPayment(payment)) {
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error validating, please check the logs", HttpStatus.EXPECTATION_FAILED);
        }
    }

    @KafkaListener(topics = "offline",
            groupId = "wefox")

    public ResponseEntity<?> listenerOffline(Payment payment) {
        paymentService.add(payment);

        return new ResponseEntity<>("Payment accepted", HttpStatus.OK);
    }

}
