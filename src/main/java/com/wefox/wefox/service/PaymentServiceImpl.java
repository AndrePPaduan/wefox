package com.wefox.wefox.service;

import com.google.gson.Gson;
import com.wefox.wefox.model.Payment;
import com.wefox.wefox.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ErrorService errorService;

    @Autowired
    private CreateHttpConnection httpConnection;

    Gson gson = new Gson();

    @Override
    public Payment add(Payment payment) {

        paymentRepository.save(payment);
        accountService.updateLastPayment(payment.getAccountId(), payment.getCreatedOn());
        return payment;
    }

    @Override
    public boolean checkPayment(Payment payment) throws IOException {

        HttpURLConnection http = httpConnection.createHttpConnection("http://localhost:9000/payment");
        String data = gson.toJson(payment);
        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        OutputStream stream = http.getOutputStream();
        stream.write(out);

        int status = http.getResponseCode();
        boolean success = status < 300;

        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());

        http.disconnect();

        if (success) {
            add(payment);
        } else {
            errorService.logError(http.getErrorStream());
        }
        return success;
    }


}
