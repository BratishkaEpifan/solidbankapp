package com.example.solidbankapp.accountService;


import com.example.solidbankapp.BankAccount.Account;
import com.example.solidbankapp.BankAccount.AccountWithdraw;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountTransferServiceImpl implements AccountTransferService{

    private final AccountWithdrawService accountWithdrawService;
    private final AccountDepositService accountDepositService;

    @Override
    public void transfer(double amount, AccountWithdraw accountWithdraw, Account accountDeposit) {
        accountWithdrawService.withdraw(amount, accountWithdraw);
        accountDepositService.deposit(amount, accountDeposit);
    }
}