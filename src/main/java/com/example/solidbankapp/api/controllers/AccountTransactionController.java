package com.example.solidbankapp.api.controllers;

import com.example.solidbankapp.BankAccount.Account;
import com.example.solidbankapp.BankAccount.AccountType;
import com.example.solidbankapp.BankAccount.AccountWithdraw;
import com.example.solidbankapp.accountService.AccountDepositService;
import com.example.solidbankapp.accountService.AccountWithdrawService;
import com.example.solidbankapp.client.BankCore;
import com.example.solidbankapp.database.SQLAccountDAO;
import com.example.solidbankapp.database.SqlTransactionDAO;
import com.example.solidbankapp.security.JwtGenerator;
import com.example.solidbankapp.transactions.Transaction;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;



@Transactional
@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountTransactionController {

    private final BankCore bankCore;
    private final AccountDepositService accountDepositService;
    private final AccountWithdrawService accountWithdrawService;
    private final SQLAccountDAO sqlAccountDAO;
    private final SqlTransactionDAO sqlTransactionDAO;

    private final JwtGenerator jwtGenerator;

    private int depositID = 1;

    private int withdrawID = -1;

    @GetMapping("1")
    public String getOne() {
        return "Sir gay";
    }

    @GetMapping("/hello")
    ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Account>> getAccounts(@RequestParam String clientID) {
        return new ResponseEntity<>(sqlAccountDAO.getClientAccounts(String.valueOf(clientID)), HttpStatus.OK);
    }

    @PostMapping("/create-account")
    public ResponseEntity<String> createAccount(@RequestParam String accountType, HttpServletRequest httpServletRequest) {
        Cookie[] cookies = httpServletRequest.getCookies();
        String token = "";
        String clientID = "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                token = cookie.getValue();
                clientID = jwtGenerator.getLoginFromToken(token);
                break;
            }
        }
        AccountType type;
        switch (accountType.toUpperCase()) {
            case "CHECKING" -> { type = new AccountType("CHECKING"); }
            case "FIXED" -> { type = new AccountType("FIXED"); }
            case "SAVING" -> { type = new AccountType("SAVING"); }
            default -> {
                type = null;
            }
        }
        if (type != null) {
            bankCore.createNewAccount(new AccountType(accountType), clientID);
            return new ResponseEntity<>("Account was successfully created!", HttpStatus.OK) ;
        } else {
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{accountId}")
    public ResponseEntity<?> getAccountById(@PathVariable String accountId, HttpServletRequest httpServletRequest) {
        Cookie[] cookies = httpServletRequest.getCookies();
        String token = "";
        String clientID = "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                token = cookie.getValue();
                clientID = jwtGenerator.getLoginFromToken(token);
                break;
            }
        }
        if (sqlAccountDAO.getClientAccount(clientID, accountId) != null) {
            return new ResponseEntity<>(sqlAccountDAO.getClientAccount(clientID, accountId), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Such account is not present!");
        }
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable String accountId, HttpServletRequest httpServletRequest) {
        Cookie[] cookies = httpServletRequest.getCookies();
        String token = "";
        String clientID = "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                token = cookie.getValue();
                clientID = jwtGenerator.getLoginFromToken(token);
                break;
            }
        }

        if (sqlAccountDAO.findById(accountId).isPresent()) {
            sqlAccountDAO.delete(sqlAccountDAO.getClientAccount(clientID, accountId));
            return new ResponseEntity<>("Account was deleted!", HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no such account!");
        }
    }

    @PostMapping("/{accountId}/deposit")
    public ResponseEntity<String> deposit(@PathVariable String accountId, HttpServletRequest httpServletRequest , @RequestParam Double amount) {
        if (amount < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please write down valid amount of money!");
        }


        Cookie[] cookies = httpServletRequest.getCookies();
        String token = "";
        String clientID = "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                token = cookie.getValue();
                clientID = jwtGenerator.getLoginFromToken(token);
                break;
            }
        }

        if (sqlAccountDAO.getClientAccount(clientID, accountId) != null) {
            sqlTransactionDAO.addTransaction(accountId, amount, depositID);
            depositID++;

            accountDepositService.deposit(amount, sqlAccountDAO.getClientAccount(clientID, accountId));
            return ResponseEntity.status(HttpStatus.OK).body("The transaction is successful!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no such account!");
        }
    }


    @PostMapping("/{accountId}/withdraw")
    public ResponseEntity<String> withdraw(@PathVariable String accountId, @RequestParam double amount, HttpServletRequest httpServletRequest) {
        if (amount < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please write down valid amount of money!");
        }
        Cookie[] cookies = httpServletRequest.getCookies();
        String token = "";
        String clientID = "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                token = cookie.getValue();
                clientID = jwtGenerator.getLoginFromToken(token);
                break;
            }
        }


        if (sqlAccountDAO.getClientAccount(clientID, accountId) != null) {
            if (sqlAccountDAO.getClientAccount(clientID, accountId).getBalance() >= amount &&
                    sqlAccountDAO.getClientAccount(clientID, accountId).isWithdrawAllowed() != false) {

                sqlTransactionDAO.addTransaction(clientID, amount, withdrawID);
                withdrawID --;

                accountWithdrawService.withdraw(amount, sqlAccountDAO.getClientWithdrawAccount(clientID, accountId));
                return ResponseEntity.status(HttpStatus.OK).body("The transaction is successful!");
            } else if (sqlAccountDAO.getClientAccount(clientID, accountId).isWithdrawAllowed() == false) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The account is fixed!");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is not enough money on your account!");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no such account!");
        }
    }


    @GetMapping("/{accountId}/transactions")
    public ResponseEntity<?> getTransactionsByID(@PathVariable String accountId) {


        if (sqlTransactionDAO.getTransactionsByID(accountId).isEmpty() == false) {
            return new ResponseEntity<>(sqlTransactionDAO.getTransactionsByID(accountId), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No transactions found");
        }
    }

}