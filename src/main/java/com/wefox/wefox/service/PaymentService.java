package com.wefox.wefox.service;

import com.wefox.wefox.model.Payment;

import java.io.IOException;

public interface PaymentService {

    public Payment add (Payment payment);
    public boolean checkPayment(Payment payment) throws IOException;
}
