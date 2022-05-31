package com.example.solidbankapp.database;

import com.example.solidbankapp.BankAccount.Account;
import com.example.solidbankapp.BankAccount.AccountType;
import com.example.solidbankapp.BankAccount.AccountWithdraw;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SQLAccountDAO extends CrudRepository<Account, String> {

    @Query("SELECT * FROM Accounts WHERE client_id = :clientID")
    List<Account> getClientAccounts(String clientID);

    @Modifying
    @Query("INSERT INTO Accounts (account_id, account_type, client_id, balance, withdraw_allowed) VALUES (:id, " +
                    ":accountType, :clientID, :balance, :withdrawAllowed)")
    void createNewAccount(String id, String accountType, String clientID, double balance, boolean withdrawAllowed);

    @Modifying
    @Query("UPDATE Accounts SET balance = :amount WHERE account_id= :id")
    void updateAccount(String id, double amount);

    @Query("SELECT * FROM Accounts WHERE client_id = :clientID AND account_type = :accountType")
    List<Account> getClientAccountsByType(String clientID, String accountType);

    @Query("SELECT * FROM Accounts WHERE client_id = :clientID AND account_id = :accountID AND withdraw_allowed = true")
    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);

    @Query("SELECT * FROM Accounts WHERE client_id = :clientID AND account_id = :accountID")
    Account getClientAccount(String clientID, String accountID);
}
