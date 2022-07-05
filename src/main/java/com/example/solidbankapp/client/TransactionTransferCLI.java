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



        if (s.isEmpty() || accountListingService.getClientWithdrawAccount(clientID, s)
                == null) {
            System.out.println("No account was found");
            return;
        }

        System.out.println("Enter account TO which you want transfer money");


        String ss = withdrawDepositOperationCLIUI.requestClientAccountNumber();



        if (ss.isEmpty() || accountListingService.getClientAccounts(ss) == null) {
            System.out.println("No account was found");
            return;
        }

        AccountWithdraw accountWithdraw = accountListingService.getClientWithdrawAccount(clientID, s);

        Account accountDeposit = accountListingService.getClientAccount(clientID, ss);

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
