/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.solidbankapp.transactions;

import com.example.solidbankapp.BankAccount.Account;
import com.example.solidbankapp.BankAccount.AccountWithdraw;
import com.example.solidbankapp.accountService.AccountWithdrawService;
import com.example.solidbankapp.database.TransactionDAO;

/**
 *
 * @author john_
 */
public class TransactionWithdraw {
    private AccountWithdrawService accountWithdrawService;
    private TransactionDAO transactionDAO;

    public TransactionWithdraw(AccountWithdrawService accountWithdrawService, TransactionDAO transactionDAO) {
        this.accountWithdrawService = accountWithdrawService;
        this.transactionDAO = transactionDAO;
    }

    public void execute (AccountWithdraw accountWithdraw, double amount, int transactionID) {
        if (accountWithdraw.getBalance() >= amount) {
            Transaction transaction = new Transaction(accountWithdraw.getID(), amount, transactionID);
            accountWithdrawService.withdraw(amount, accountWithdraw);
            transactionDAO.addTransaction(transaction);
            System.out.println("The transaction is successful!");
        }  else {
            System.out.println("There is not enough money on the account!");
        }
    }
}
