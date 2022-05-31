/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.solidbankapp.transactions;

import com.example.solidbankapp.BankAccount.Account;
import com.example.solidbankapp.BankAccount.AccountWithdraw;
import com.example.solidbankapp.accountService.AccountDepositService;
import com.example.solidbankapp.database.SqlTransactionDAO;
import com.example.solidbankapp.database.TransactionDAO;
import org.springframework.stereotype.Component;

/**
 *
 * @author john_
 */
@Component
public class TransactionDeposit {
    private AccountDepositService accountDepositService;
    //private TransactionDAO transactionDAO;
    private SqlTransactionDAO sqlTransactionDAO;

    public TransactionDeposit(AccountDepositService accountDepositService, SqlTransactionDAO sqlTransactionDAO) {
        this.accountDepositService = accountDepositService;
        this.sqlTransactionDAO = sqlTransactionDAO;
    }

    public void execute (Account account, double amount, int transactionID) {
        accountDepositService.deposit(amount, account);
        sqlTransactionDAO.addTransaction(account.getID(), amount, transactionID);
        System.out.println("The transaction is successful!");
    }

}
