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
        String id = account.getClientID();
        List<Account> list = accountDAO.getClientAccountsByType(id, AccountType.CHECKING);
        for (Account i : list) {
            if (i.equals(account)) {
                if (account.getBalance() <= amount) {
                    System.out.println("There is not enough money on the account!");
                    return;
                } else {
                    account.setBalance(account.getBalance() - amount);
                    return;
                }
            }
        }
        System.out.println("No such account found in the database!");
    }
}
