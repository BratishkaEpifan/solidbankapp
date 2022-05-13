/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.solidbankapp.accountService;
import com.example.solidbankapp.AccountDAO;
import com.example.solidbankapp.BankAccount.Account;
import com.example.solidbankapp.BankAccount.CheckingAccount;
import com.example.solidbankapp.BankAccount.FixedAccount;
import com.example.solidbankapp.BankAccount.SavingAccount;
import com.example.solidbankapp.BankAccount.AccountType;
/**
 *
 * @author john_
 */
public class AccountCreationServiceImpl implements AccountCreationService {
    private AccountDAO accountDAO;

    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
    
    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        try {
            Account newAccount = switch (accountType) {
                case CHECKING -> new CheckingAccount(accountType, Long.toString(accountID), clientID, 0, true);
                case FIXED -> new FixedAccount(accountType, Long.toString(accountID), clientID, 0, false);
                case SAVING -> new SavingAccount(accountType, Long.toString(accountID), clientID, 0, true);
            };
            System.out.println("Account successfully created");
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
}
