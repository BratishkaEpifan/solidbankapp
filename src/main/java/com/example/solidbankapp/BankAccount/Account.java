/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.solidbankapp.BankAccount;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;



/**
 *
 * @author john_
 */
@NoArgsConstructor
@Table
@Component
public class Account {

    private @Column("account_type") AccountType accountType;
    private @Id
    @Column("account_id") String id;
    private @Column("client_id") String clientID;
    private @Column("balance") double balance;
    private @Column("withdraw_allowed") boolean withdrawAllowed;

    public double getBalance() {
        return balance;
    }
    
    @Override
    public String toString() {
        int n = Integer.parseInt(id);
        String accountNumber = String.format("%03d%06d", 1, n);

        return "Account{" +
                "accountType=" + accountType.getType() +
                ", id='" + accountNumber +
                ", clientID='" + clientID +
                ", balance=" + balance +
                ", withdrawAllowed=" + withdrawAllowed +
                '}';
    }
    
    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }
    
    public Account(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        this.accountType = accountType;
        this.id = id;
        this.clientID = clientID;
        this.balance = balance;
        this.withdrawAllowed = withdrawAllowed;
    }



    public boolean isWithdrawAllowed() {
        return withdrawAllowed;
    }

    public void setWithdrawAllowed(boolean withdrawAllowed) {
        this.withdrawAllowed = withdrawAllowed;
    }
    
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
    
    public String getID() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    
}

