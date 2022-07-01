package com.example.solidbankapp.client;

import com.example.solidbankapp.BankAccount.Account;
import com.example.solidbankapp.BankAccount.AccountWithdraw;
import com.example.solidbankapp.accountService.AccountListingService;
import com.example.solidbankapp.accountService.AccountTransferService;
import com.example.solidbankapp.transactions.WithdrawDepositOperationCLIUI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionTransferCLI {
    private final AccountTransferService accountTransferService;
    private final WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private final AccountListingService accountListingService;

    public void transferMoney(String clientID) {

        System.out.println("Enter account ID that you want to take money from");
        String s = withdrawDepositOperationCLIUI.requestClientAccountNumber();

        long l=Long.parseLong(s);
        l = l - 1000000;
        String accountNumberFrom = String.valueOf(l);

        if (accountNumberFrom.isEmpty() || accountListingService.getClientWithdrawAccount(clientID, accountNumberFrom)
                == null) {
            System.out.println("No account was found");
            return;
        }

        System.out.println("Enter account TO which you want transfer money");


        String ss = withdrawDepositOperationCLIUI.requestClientAccountNumber();

        long t=Long.parseLong(ss);
        t = t - 1000000;
        String accountNumberTo = String.valueOf(t);

        if (accountNumberTo.isEmpty() || accountListingService.getClientAccounts(accountNumberTo) == null) {
            System.out.println("No account was found");
            return;
        }

        AccountWithdraw accountWithdraw = accountListingService.getClientWithdrawAccount(clientID, accountNumberFrom);

        Account accountDeposit = accountListingService.getClientAccount(clientID, accountNumberTo);

        System.out.println("Enter amount of money");
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        if (amount > 0 && accountWithdraw.getBalance() >= amount) {
            accountTransferService.transfer(amount, accountWithdraw, accountDeposit);
            System.out.println(amount + "$ were transferred from account " + s +
                    " to account " + ss);
        } else {
            System.out.println("Not enough money on your account!");
        }
    }
}
