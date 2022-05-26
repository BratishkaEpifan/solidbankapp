/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.example.solidbankapp;
import java.util.Scanner;
import java.util.List;

import com.example.solidbankapp.client.AccountBasicCLI;
import com.example.solidbankapp.client.MyCLI;
import com.example.solidbankapp.client.TransactionDepositCLI;
import com.example.solidbankapp.client.TransactionWithdrawCLI;
import com.example.solidbankapp.springAnnotations.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author john_
 */
@SpringBootApplication
public class SOLIDBankApp implements CommandLineRunner {

    @Autowired
    private ApplicationContext context;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(SOLIDBankApp.class);
    }
    public void run (String... arg0) throws Exception {
        
        // TODO code application logic here
        String message = "1 - show accounts\n" +
                "2 - create account\n" +
                "3 - deposit\n" +
                "4 - withdraw\n" +
                "5 - transfer\n" +
                "6 - this message\n" +
                "7 - exit\n";

        System.out.print("Welcome to CLI Bank service\nEnter operation number:\n");
        System.out.print(message);

        //ApplicationContext context = new ClassPathXmlApplicationContext("props.xml");
        context = new AnnotationConfigApplicationContext(AppConfig.class);

        AccountBasicCLI accountBasicCLI =  context.getBean(AccountBasicCLI.class);
        TransactionDepositCLI transactionDepositCLI = context.getBean(TransactionDepositCLI.class);
        TransactionWithdrawCLI transactionWithdrawCLI = context.getBean(TransactionWithdrawCLI.class);
        MyCLI myCLI = (MyCLI) context.getBean(MyCLI.class);

        String clientID = "1";

        boolean isRunning = true;
        while (isRunning == true) {
            String input = (myCLI.getScanner()).nextLine();
            switch (input) {
                case "1" -> accountBasicCLI.getAccounts(clientID);
                case "2" -> accountBasicCLI.createAccountRequest(clientID);
                case "3" -> transactionDepositCLI.depositMoney(clientID);
                case "4" -> transactionWithdrawCLI.withdrawMoney(clientID);
                case "5" -> System.out.println("This command is not available yet");
                case "6" -> System.out.println(message);
                case "7" -> {
                    System.out.println("Application closed");
                    isRunning = false;
                }
                default -> System.out.println("Invalid command");
            }
        }
        myCLI.getScanner().close();
    }

    
}
