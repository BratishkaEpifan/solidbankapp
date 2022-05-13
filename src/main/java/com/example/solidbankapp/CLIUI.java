/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.solidbankapp;
import com.example.solidbankapp.createAccount.CreateAccountOperationUI;
import com.example.solidbankapp.BankAccount.AccountType;
/**
 *
 * @author john_
 */
public interface CLIUI extends CreateAccountOperationUI {
    public AccountType requestAccountType();    
}
