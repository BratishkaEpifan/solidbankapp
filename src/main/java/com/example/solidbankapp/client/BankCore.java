/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.solidbankapp.client;
import com.example.solidbankapp.accountService.AccountCreationService;
import com.example.solidbankapp.BankAccount.AccountType;
import com.example.solidbankapp.accountService.AccountListingServiceImpl;

/**
 *
 * @author john_
 */
public class BankCore {
    private static long id = 1;
    private long lastAccountNumber = 1;
    private AccountCreationService accountCreation;
    
    public BankCore(AccountCreationService accountCreation) {
        this.accountCreation = accountCreation;
    }


    public void createNewAccount(AccountType accountType, String clientID) {
        accountCreation.create(accountType, id, clientID, lastAccountNumber);
        incrementLastAccountNumber();
    }
    
    private void incrementLastAccountNumber() {
        lastAccountNumber = lastAccountNumber + 1;
    }    
}
