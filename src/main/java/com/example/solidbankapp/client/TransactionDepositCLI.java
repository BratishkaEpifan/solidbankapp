/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.solidbankapp.client;

import com.example.solidbankapp.BankAccount.Account;
import com.example.solidbankapp.accountService.AccountListingService;
import com.example.solidbankapp.transactions.TransactionDeposit;
import com.example.solidbankapp.transactions.WithdrawDepositOperationCLIUI;

/**
 *
 * @author john_
 */
public class TransactionDepositCLI {
    TransactionDeposit transactionDeposit;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListing;

    private static int transactionID = 148800;


    public TransactionDepositCLI(TransactionDeposit transactionDeposit, WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI, AccountListingService accountListing) {
        this.transactionDeposit = transactionDeposit;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListing = accountListing;
    }
    public void depositMoney(String clientID) {
        System.out.println("Please enter your account ID");
        String temp = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        if (temp != null) {
            long l=Long.parseLong(temp);
            l = l - 1000000;
            String accountID = String.valueOf(l);
            Account account = accountListing.getClientAccount(clientID, accountID);
            if (account != null) {
                System.out.println("Please enter the amount");
                double amount = withdrawDepositOperationCLIUI.requestClientAmount();
                if (amount <=0) {
                    System.out.println("Invalid amount");
                } else {
                    transactionDeposit.execute(account, amount, transactionID);
                    incrementTransactionID();
                }
            } else {
                System.out.println("Sorry, you don't have an account with such ID");
            }
        } else {
            System.out.println("No account found");
        }
    }

    private void incrementTransactionID() {
        transactionID++;
    }



}
