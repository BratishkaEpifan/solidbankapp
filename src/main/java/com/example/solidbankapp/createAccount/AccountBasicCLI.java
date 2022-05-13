/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.solidbankapp.createAccount;
import com.example.solidbankapp.BankAccount.Account;
import com.example.solidbankapp.accountService.AccountListingService;
import com.example.solidbankapp.BankAccount.AccountType;

import java.util.List;
/**
 *
 * @author john_
 */
public class AccountBasicCLI {
    
    private CreateAccountOperationUI createAccountOperationUI;
    private BankCore bankCore;
    private AccountListingService accountListing;

    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore, AccountListingService accountListing) {
        this.createAccountOperationUI = createAccountOperationUI;
        this.bankCore = bankCore;
        this.accountListing = accountListing;
    }

    public void createAccountRequest(String clientID) {
        if (createAccountOperationUI.requestAccountType() != null) {
            bankCore.createNewAccount(createAccountOperationUI.requestAccountType(), clientID);
        }
    }
    
    public void getAccounts(String clientID) {
        System.out.println(accountListing.getClientAccounts(clientID));
    }    
    
}
