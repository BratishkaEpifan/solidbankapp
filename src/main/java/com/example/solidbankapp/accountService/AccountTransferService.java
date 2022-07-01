package com.example.solidbankapp.accountService;

import com.example.solidbankapp.BankAccount.Account;
import com.example.solidbankapp.BankAccount.AccountWithdraw;

public interface AccountTransferService {
    void transfer(double amount, AccountWithdraw accountWithdraw, Account accountDeposit);
}