/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.solidbankapp.client;

import com.example.solidbankapp.BankAccount.AccountWithdraw;
import com.example.solidbankapp.accountService.AccountListingService;
import com.example.solidbankapp.transactions.TransactionWithdraw;
import com.example.solidbankapp.transactions.WithdrawDepositOperationCLIUI;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author john_
 */
public class TransactionWithdrawCLI {
    private TransactionWithdraw transactionWithdraw;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private AccountListingService accountListing;

    private static int transactionID = 22800;

    public TransactionWithdrawCLI(TransactionWithdraw transactionWithdraw, WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI, AccountListingService accountListing) {
        this.transactionWithdraw = transactionWithdraw;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListing = accountListing;
    }

    public void withdrawMoney(String clientID) {
        System.out.println("Please enter your account ID");
        String temp = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        if (temp != null) {
            long l=Long.parseLong(temp);
            l = l - 1000000;
            String accountID = String.valueOf(l);
            AccountWithdraw account = accountListing.getClientWithdrawAccount(clientID, accountID);
            if (account != null) {
                System.out.println("Please enter the amount");
                double amount = withdrawDepositOperationCLIUI.requestClientAmount();
                if (amount <=0) {
                    System.out.println("Invalid amount");
                } else {
                    transactionWithdraw.execute(account, amount, transactionID);
                    incrementTransactionID();
                }
            } else {
                System.out.println("Sorry, you don't have a withdraw account with such ID");
            }
        } else {
            System.out.println("No account found");
        }
    }

    private void incrementTransactionID() {
        transactionID++;
    }
}
