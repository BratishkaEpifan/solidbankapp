package com.example.solidbankapp.transactions;

import com.example.solidbankapp.BankAccount.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table
public class Transaction {
    private @Column("account_id") String accountID;
    private @Column("amount") double amount;
    private @Id
    @Column("transaction_id") int transactionID;
}
