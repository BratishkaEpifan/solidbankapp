/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.solidbankapp.client;
import com.example.solidbankapp.BankAccount.AccountType;
import com.example.solidbankapp.transactions.WithdrawDepositOperationCLIUI;
import org.springframework.stereotype.Component;

/**
 *
 * @author john_
 */
@Component
public interface CLIUI extends CreateAccountOperationUI, WithdrawDepositOperationCLIUI {
    public AccountType requestAccountType();    
}
