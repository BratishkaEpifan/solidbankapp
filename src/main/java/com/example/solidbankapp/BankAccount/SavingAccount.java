/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.solidbankapp.BankAccount;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 *
 * @author john_
 */
@Component
@NoArgsConstructor
public class SavingAccount extends AccountWithdraw {
    public SavingAccount(String accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }
}
