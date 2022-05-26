/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.solidbankapp.transactions;

import com.example.solidbankapp.BankAccount.Account;
import com.example.solidbankapp.BankAccount.AccountWithdraw;
import com.example.solidbankapp.accountService.AccountDepositService;
import com.example.solidbankapp.database.TransactionDAO;

/**
 *
 * @author john_
 */
public class TransactionDeposit {
    private AccountDepositService accountDepositService;
    private TransactionDAO transactionDAO;

    public TransactionDeposit(AccountDepositService accountDepositService, TransactionDAO transactionDAO) {
        this.accountDepositService = accountDepositService;
        this.transactionDAO = transactionDAO;
    }

    public void execute (Account account, double amount, int transactionID) {
        Transaction transaction = new Transaction(account.getID(), amount, transactionID);
        transactionDAO.addTransaction(transaction);
        accountDepositService.deposit(amount, account);
        transactionDAO.addTransaction(transaction);
        System.out.println("The transaction is successful!");
    }

}
