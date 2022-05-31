/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.solidbankapp.transactions;

import org.springframework.stereotype.Component;

/**
 *
 * @author john_
 */
@Component
public interface WithdrawDepositOperationCLIUI {
    public double requestClientAmount();
    public String requestClientAccountNumber();
}
