package com.example.solidbankapp.springAnnotations;

import com.example.solidbankapp.accountService.AccountCreationServiceImpl;
import com.example.solidbankapp.accountService.AccountDepositServiceImpl;
import com.example.solidbankapp.accountService.AccountListingServiceImpl;
import com.example.solidbankapp.accountService.AccountWithdrawServiceImpl;
import com.example.solidbankapp.client.*;
import com.example.solidbankapp.database.MemoryAccountDAO;
import com.example.solidbankapp.database.MemoryTransactionDAO;
import com.example.solidbankapp.transactions.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public AccountCreationServiceImpl accountCreationServiceImpl() {
        return new AccountCreationServiceImpl(accountDAO());
    }
    @Bean
    public AccountListingServiceImpl accountListing() {
        return new AccountListingServiceImpl(accountDAO());
    }
    @Bean
    public BankCore bankCore() {
        return new BankCore(accountCreationServiceImpl());
    }
    @Bean
    public MyCLI myCLI() {
        return new MyCLI();
    }
    @Bean
    public AccountBasicCLI accountBasicCLI() {
        return new AccountBasicCLI(myCLI(), bankCore(), accountListing());
    }
    @Bean
    public TransactionWithdrawCLI transactionWithdrawCLI() {
        return new TransactionWithdrawCLI(transactionWithdraw(), myCLI(), accountListing());
    }
    @Bean
    public TransactionDepositCLI transactionDepositCLI() {
        return new TransactionDepositCLI(transactionDeposit(), myCLI(), accountListing());
    }
    @Bean
    public TransactionWithdraw transactionWithdraw() {
        return new TransactionWithdraw(accountWithdrawService(), transactionDAO());
    }
    @Bean
    public TransactionDeposit transactionDeposit() {
        return new TransactionDeposit(accountDepositService(), transactionDAO());
    }
    @Bean
    public AccountDepositServiceImpl accountDepositService() {
        return new AccountDepositServiceImpl(accountDAO());
    }
    @Bean
    public MemoryTransactionDAO transactionDAO() {
        return new MemoryTransactionDAO();
    }
    @Bean
    public AccountWithdrawServiceImpl accountWithdrawService() {
        return new AccountWithdrawServiceImpl(accountDAO());
    }
    @Bean
    public MemoryAccountDAO accountDAO(){
        return new MemoryAccountDAO();
    }
    /*@Bean
    public WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI() {
        return new MyCLI();
    }
    @Bean
    public CreateAccountOperationUI createAccountOperationUI() {
        return new MyCLI();
    }*/


}
