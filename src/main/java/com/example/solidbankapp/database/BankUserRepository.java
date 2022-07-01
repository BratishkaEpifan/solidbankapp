package com.example.solidbankapp.database;

import com.example.solidbankapp.security.BankUser;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankUserRepository extends CrudRepository<BankUser, Long> {

    @Query ("INSERT INTO Users (login, password, role) VALUES (:login, :password, :role)")
    @Modifying
    void register (String login, String password, String role);


    @Query("SELECT CASE WHEN EXISTS (\n" +
            "    SELECT *\n" +
            "    FROM Users \n" +
            "    WHERE login = :username \n" +
            ")\n" +
            "THEN CAST(1 AS BIT)\n" +
            "ELSE CAST(0 AS BIT) END")
    boolean existsByUsername(String username);


    BankUser findBankUserByLogin(String login);
    @Query("SELECT * FROM Users WHERE login = :login")
    BankUser findByLogin(String login);

    @Query("SELECT * FROM Users")
    List<BankUser> findAll ();

    BankUser findById(long clientID);
}
