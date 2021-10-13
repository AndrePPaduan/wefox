package com.wefox.wefox.service;

import com.wefox.wefox.model.Account;
import com.wefox.wefox.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void updateLastPayment(int accountId, Timestamp paymentCreationDate) {
        Account account = accountRepository.getById(String.valueOf(accountId));
        account.setLastPayment(paymentCreationDate);
    }
}
