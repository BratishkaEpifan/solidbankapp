/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.solidbankapp.accountService;
import com.example.solidbankapp.BankAccount.AccountWithdraw;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author john_
 */

@Service
public interface AccountWithdrawService {
     void withdraw(double amount, AccountWithdraw account);
}
