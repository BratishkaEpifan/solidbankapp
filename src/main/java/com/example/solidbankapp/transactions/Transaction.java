package com.example.solidbankapp.transactions;

import com.example.solidbankapp.BankAccount.Account;

public class Transaction {
    private String accountID;
    private double amount;

    private int transactionID;



    public Transaction(String accountID, double amount, int transactionID) {
        this.accountID = accountID;
        this.amount = amount;
        this.transactionID = transactionID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccount(String accountID) {
        this.accountID = accountID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
