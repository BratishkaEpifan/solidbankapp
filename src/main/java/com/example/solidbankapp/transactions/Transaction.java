package com.example.solidbankapp.transactions;

import com.example.solidbankapp.BankAccount.Account;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Getter
@Setter
@Table
public class Transaction {
    private @Column("account_id") final String accountID;
    private @Column("amount") final double amount;
    private @Id
    @Column("transaction_id") final int transactionID;
}
