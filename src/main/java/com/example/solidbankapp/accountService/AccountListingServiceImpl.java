/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.solidbankapp.accountService;
import com.example.solidbankapp.BankAccount.Account;
import com.example.solidbankapp.BankAccount.AccountWithdraw;
import com.example.solidbankapp.BankAccount.AccountType;
import com.example.solidbankapp.database.SQLAccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author john_
 */
@Service
public class AccountListingServiceImpl implements AccountListingService {

    @Autowired
    private SQLAccountDAO sqlAccountDAO;


    @Override
    public Account getClientAccount(String clientID, String accountID) {
        Account result = sqlAccountDAO.getClientAccount(clientID, accountID);
        return result;
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        AccountWithdraw result = sqlAccountDAO.getClientWithdrawAccount(clientID, accountID);
        return result;
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return sqlAccountDAO.getClientAccounts(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        List<Account> result = sqlAccountDAO.getClientAccountsByType(clientID, String.valueOf(accountType));
        return result;
    }

//    private AccountDAO accountDAO;
//    public AccountListingServiceImpl(AccountDAO accountDAO) {
//        this.accountDAO = accountDAO;
//    }
//
//    @Override
//    public Account getClientAccount(String clientID, String accountID) {
//        Account result = accountDAO.getClientAccount(clientID, accountID);
//        return result;
//    }
//
//    @Override
//    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
//        AccountWithdraw result = accountDAO.getClientWithdrawAccount(clientID, accountID);
//        return result;
//    }
//
//    @Override
//    public List<Account> getClientAccounts(String clientID) {
//        return accountDAO.getClientAccounts(clientID);
//    }
//
//    @Override
//    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
//        List<Account> result = accountDAO.getClientAccountsByType(clientID, accountType);
//        return result;
//    }
}
