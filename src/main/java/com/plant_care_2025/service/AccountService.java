package com.plant_care_2025.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plant_care_2025.model.Account;
import com.plant_care_2025.repository.AccountRepository;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountByNumber(String accountNumber) {
        return accountRepository.findById(accountNumber).orElse(null);
    }

    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    public void deleteAccount(String accountNumber) {
        accountRepository.deleteById(accountNumber);
    }
}

