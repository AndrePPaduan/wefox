package com.wefox.wefox.service;

import java.sql.Timestamp;

public interface AccountService {
    public void updateLastPayment(int accountId, Timestamp paymentCreationDate);
}

