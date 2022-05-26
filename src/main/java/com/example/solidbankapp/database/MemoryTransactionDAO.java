/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.solidbankapp.database;
import com.example.solidbankapp.transactions.Transaction;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author john_
 */
public class MemoryTransactionDAO implements TransactionDAO {

    private List<Transaction> transactions;

    public MemoryTransactionDAO () {
        transactions = new ArrayList<Transaction>();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
