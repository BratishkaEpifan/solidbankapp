/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.solidbankapp.accountService;


/**
 *
 * @author john_
 */

import com.example.solidbankapp.BankAccount.Account;
import com.example.solidbankapp.database.AccountDAO;

import java.util.List;

public class AccountDepositServiceImpl implements AccountDepositService {

    private AccountDAO accountDAO;

    public AccountDepositServiceImpl (AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }


    public void deposit(double amount, Account account) {
        accountDAO.updateAccount(account, account.getBalance() + amount);
    }
}
