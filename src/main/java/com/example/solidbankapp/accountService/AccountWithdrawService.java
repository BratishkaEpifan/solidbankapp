/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.solidbankapp.accountService;
import com.example.solidbankapp.BankAccount.AccountWithdraw;

/**
 *
 * @author john_
 */
public interface AccountWithdrawService {
    public void withdraw(double amount, AccountWithdraw account);
}
