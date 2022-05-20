/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.solidbankapp;
import java.util.List;
import com.example.solidbankapp.BankAccount.Account;
import com.example.solidbankapp.BankAccount.AccountType;
import com.example.solidbankapp.BankAccount.AccountWithdraw;

/**
 *
 * @author john_
 */
public interface AccountDAO {
    
    public List<Account> getClientAccounts(String clientID);
    
    public void createNewAccount(Account account);
    
    public void updateAccount(Account account, double amount);
    
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType);
    
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);
    
    public Account getClientAccount(String clientID, String accountID);
    
}
