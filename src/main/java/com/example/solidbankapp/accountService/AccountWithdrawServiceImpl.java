/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.solidbankapp.accountService;

import com.example.solidbankapp.AccountDAO;
import com.example.solidbankapp.BankAccount.Account;
import com.example.solidbankapp.BankAccount.AccountType;
import com.example.solidbankapp.BankAccount.AccountWithdraw;

import java.util.List;

/**
 *
 * @author john_
 */
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    private AccountDAO accountDAO;

    public AccountWithdrawServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void withdraw(double amount, AccountWithdraw account) {
        accountDAO.updateAccount(account, account.getBalance() - amount);
    }
}
