/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.solidbankapp.client;
import com.example.solidbankapp.BankAccount.AccountType;
import com.example.solidbankapp.transactions.WithdrawDepositOperationCLIUI;

/**
 *
 * @author john_
 */
public interface CLIUI extends CreateAccountOperationUI, WithdrawDepositOperationCLIUI {
    public AccountType requestAccountType();    
}
