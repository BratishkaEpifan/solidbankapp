/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.solidbankapp.database;
import com.example.solidbankapp.transactions.Transaction;

import java.util.List;
/**
 *
 * @author john_
 */
public interface TransactionDAO {
    public List<Transaction> getTransactions();
    public void addTransaction(Transaction transaction);
}
