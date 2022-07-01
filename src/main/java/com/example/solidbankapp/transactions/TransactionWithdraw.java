/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.solidbankapp.transactions;

import com.example.solidbankapp.BankAccount.Account;
import com.example.solidbankapp.BankAccount.AccountWithdraw;
import com.example.solidbankapp.accountService.AccountWithdrawService;
import com.example.solidbankapp.database.SqlTransactionDAO;
import com.example.solidbankapp.database.TransactionDAO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author john_
 */
@Component
@AllArgsConstructor
public class TransactionWithdraw {

    private AccountWithdrawService accountWithdrawService;
    //private TransactionDAO transactionDAO;
    private SqlTransactionDAO sqlTransactionDAO;


    public void execute (AccountWithdraw accountWithdraw, double amount, int transactionID) {
        if (accountWithdraw.getBalance() >= amount) {
            Transaction transaction = new Transaction(accountWithdraw.getId(), amount, transactionID);
            accountWithdrawService.withdraw(amount, accountWithdraw);
            sqlTransactionDAO.addTransaction(transaction.getAccountID(), transaction.getAmount(), transaction.getTransactionID());
            System.out.println("The transaction is successful!");
        }  else {
            System.out.println("There is not enough money on the account!");
        }
    }



//    public TransactionWithdraw(AccountWithdrawService accountWithdrawService, TransactionDAO transactionDAO) {
//        this.accountWithdrawService = accountWithdrawService;
//        this.transactionDAO = transactionDAO;
//    }
//
//    public void execute (AccountWithdraw accountWithdraw, double amount, int transactionID) {
//        if (accountWithdraw.getBalance() >= amount) {
//            Transaction transaction = new Transaction(accountWithdraw.getID(), amount, transactionID);
//            accountWithdrawService.withdraw(amount, accountWithdraw);
//            transactionDAO.addTransaction(transaction);
//            System.out.println("The transaction is successful!");
//        }  else {
//            System.out.println("There is not enough money on the account!");
//        }
//    }
}
