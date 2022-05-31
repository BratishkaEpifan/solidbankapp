package com.example.solidbankapp.database;

import com.example.solidbankapp.transactions.Transaction;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SqlTransactionDAO extends CrudRepository<Transaction, Integer> {
    @Query("SELECT * FROM Transactions")
    public List<Transaction> getTransactions();

    @Modifying
    @Query("INSERT INTO Transactions (account_id, amount, transaction_id) VALUES (:accountID, :amount, :transactionID)")
    public void addTransaction(String accountID, double amount, int transactionID);

}
