/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.solidbankapp.accountService;
import com.example.solidbankapp.BankAccount.Account;
import com.example.solidbankapp.BankAccount.AccountWithdraw;
import com.example.solidbankapp.BankAccount.AccountType;
import com.example.solidbankapp.database.AccountDAO;

import java.util.List;

/**
 *
 * @author john_
 */
public class AccountListingServiceImpl implements AccountListingService {
    private AccountDAO accountDAO;

    public AccountListingServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        Account result = accountDAO.getClientAccount(clientID, accountID);
        return result;
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        AccountWithdraw result = accountDAO.getClientWithdrawAccount(clientID, accountID);
        return result;
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountDAO.getClientAccounts(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        List<Account> result = accountDAO.getClientAccountsByType(clientID, accountType);
        return result;
    }    
}
