package com.example.solidbankapp.transactions;

import com.example.solidbankapp.BankAccount.Account;

public class Transaction {
    private Account account;
    private double amount;

    public Transaction(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
