/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.solidbankapp.database;

import com.example.solidbankapp.BankAccount.Account;
import com.example.solidbankapp.BankAccount.AccountType;
import com.example.solidbankapp.BankAccount.AccountWithdraw;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author john_
 */

public class MemoryAccountDAO implements AccountDAO {
    private List<Account> accountList;

    public MemoryAccountDAO() {
        this.accountList = new ArrayList<Account>();
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        List<Account> result = new LinkedList<Account>();
        for (Account i: accountList) {
            if (i.getClientID().equals(clientID)) {
                result.add(i);
            }
        }
        return result;
    }

    @Override
    public void createNewAccount(Account account) {
        accountList.add(account);
    }


    @Override
    public void updateAccount(Account account, double amount) {
        account.setBalance(amount);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        List<Account> result = new LinkedList<Account> ();
        for (Account i: accountList) {
            if (i.getAccountType().equals(accountType)) {
                result.add(i);
            }
        }
        return result;
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        AccountWithdraw result = null;
        for (Account i: accountList) {
            if (i.getClientID().equals(clientID) && i.getID().equals(accountID)) {
                if (i.isWithdrawAllowed() == true) {
                    result = (AccountWithdraw)i;
                    break;
                } else {
                    System.out.println("Your account is fixed!");
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        Account result = null;
        for (Account i: accountList) {
            if (i.getClientID().equals(clientID) && i.getID().equals(accountID)) {
                result = i;
                break;
            }
        }
        return result;
    }    
}
