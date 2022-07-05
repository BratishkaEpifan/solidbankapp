/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.solidbankapp.accountService;
import com.example.solidbankapp.BankAccount.Account;
import com.example.solidbankapp.BankAccount.CheckingAccount;
import com.example.solidbankapp.BankAccount.FixedAccount;
import com.example.solidbankapp.BankAccount.SavingAccount;
import com.example.solidbankapp.BankAccount.AccountType;

import com.example.solidbankapp.database.SQLAccountDAO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author john_
 */

@Service
@Data
@AllArgsConstructor
public class AccountCreationServiceImpl implements AccountCreationService {

 //private AccountDAO accountDAO;

    private SQLAccountDAO sqlAccountDAO;


    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        try {
            Account newAccount = switch (accountType.getType().toUpperCase())  {
                case "CHECKING" -> new CheckingAccount(accountType.getType(), Long.toString(accountID), clientID, 0, true);
                case "FIXED" -> new FixedAccount(accountType.getType(), Long.toString(accountID), clientID, 0, false);
                case "SAVING" -> new SavingAccount(accountType.getType(), Long.toString(accountID), clientID, 0, true);
                default -> null;
            };
            //accountDAO.createNewAccount(newAccount);
            if (newAccount != null) {

                int n = Integer.parseInt(newAccount.getId());
                String accountNumber = String.format("%03d%06d", 1, n);

                sqlAccountDAO.createNewAccount(accountNumber, newAccount.getAccountType(), newAccount.getClientID(),
                        newAccount.getBalance(), newAccount.isWithdrawAllowed());
                System.out.println("Account successfully created");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
