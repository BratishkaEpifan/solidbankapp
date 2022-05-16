/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.solidbankapp.accountService;


/**
 *
 * @author john_
 */
import com.example.solidbankapp.AccountDAO;
import com.example.solidbankapp.BankAccount.Account;
import com.example.solidbankapp.BankAccount.AccountType;
import com.example.solidbankapp.BankAccount.AccountWithdraw;

import java.util.List;

public class AccountDepositServiceImpl implements AccountDepositService {

    private AccountDAO accountDAO;

    public AccountDepositServiceImpl (AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }


    public void deposit(double amount, Account account) {
        String id = account.getClientID();
        List<Account> list = accountDAO.getClientAccounts(id);
        for (Account i : list) {
            if (i.equals(account) == true) {
                account.setBalance(account.getBalance() + amount);
                System.out.println("The transaction is successful!");
                return;
            }
        }
        System.out.println("No such account found in the database!");
    }
}
