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
import com.example.solidbankapp.database.SQLAccountDAO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountDepositServiceImpl implements AccountDepositService {

    //private AccountDAO accountDAO;


    private SQLAccountDAO sqlAccountDAO;

    public void deposit(double amount, Account account) {
        sqlAccountDAO.updateAccount(account.getId(), account.getBalance() + amount);
    }
}
