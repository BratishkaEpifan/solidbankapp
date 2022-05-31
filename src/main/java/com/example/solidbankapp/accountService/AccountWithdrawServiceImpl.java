/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.solidbankapp.accountService;

import com.example.solidbankapp.BankAccount.AccountWithdraw;
import com.example.solidbankapp.database.SQLAccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author john_
 */

@Service
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    //private AccountDAO accountDAO;


    @Autowired
    private SQLAccountDAO sqlAccountDAO;


    public void withdraw(double amount, AccountWithdraw account) {
        sqlAccountDAO.updateAccount(account.getID(), account.getBalance() - amount);
    }
}
