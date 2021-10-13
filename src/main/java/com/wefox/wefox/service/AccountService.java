package com.wefox.wefox.service;

import java.sql.Timestamp;
import java.util.UUID;

public interface AccountService {
    public void updateLastPayment(Integer accountId, Timestamp paymentCreationDate);
}

