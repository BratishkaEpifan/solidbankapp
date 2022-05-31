/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.solidbankapp.accountService;
import com.example.solidbankapp.BankAccount.Account;
import org.springframework.stereotype.Service;

/**
 *
 * @author john_
 */
@Service
public interface AccountDepositService {
    public void deposit(double amount, Account account);
}
