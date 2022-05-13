/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.solidbankapp.accountService;
import com.example.solidbankapp.BankAccount.AccountType;

/**
 *
 * @author john_
 */
public interface AccountCreationService {

    public void create(AccountType accountType, long bankID, String clientID, long accountID);
}
