/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.solidbankapp.BankAccount;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@Getter
@Setter
@Component
public class Account {

    private @Column("account_type") String accountType;
    private @Id
    @Column("account_id") String id;
    private @Column("client_id") String clientID;
    private @Column("balance") double balance;
    private @Column("withdraw_allowed") boolean withdrawAllowed;


    
    @Override
    public String toString() {
        int n = Integer.parseInt(id);
        String accountNumber = String.format("%03d%06d", 1, n);

        return "Account{" +
                "accountType=" + accountType +
                ", id='" + accountNumber +
                ", clientID='" + clientID +
                ", balance=" + balance +
                ", withdrawAllowed=" + withdrawAllowed +
                '}';
    }
    

    
    public Account(String accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        this.accountType = accountType;
        this.id = id;
        this.clientID = clientID;
        this.balance = balance;
        this.withdrawAllowed = withdrawAllowed;
    }




    
}

