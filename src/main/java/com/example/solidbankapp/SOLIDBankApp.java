/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.example.solidbankapp;
import java.util.Scanner;
import java.util.List;
import com.example.solidbankapp.BankAccount.Account;
import com.example.solidbankapp.BankAccount.AccountType;
import com.example.solidbankapp.accountService.AccountListingServiceImpl;
import com.example.solidbankapp.createAccount.AccountBasicCLI;
import com.example.solidbankapp.createAccount.CreateAccountOperationUI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author john_
 */
public class SOLIDBankApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
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
        ApplicationContext context = new ClassPathXmlApplicationContext("props.xml");
        AccountBasicCLI accountBasicCLI =  context.getBean(AccountBasicCLI.class);
        MyCLI myCLI = (MyCLI) context.getBean("myCLI");

        String clientID = "1";

        boolean isRunning = true;
        while (isRunning == true) {
            String input = (myCLI.getScanner()).nextLine();
            switch (input) {
                case "1" -> accountBasicCLI.getAccounts(clientID);
                case "2" -> accountBasicCLI.createAccountRequest(clientID);
                case "3" -> System.out.println("This command is not available yet");
                case "4" -> System.out.println("This command is not available yet");
                case "5" -> System.out.println("This command is not available yet");
                case "6" -> System.out.println(message);
                case "7" -> {
                    System.out.println("Application closed");
                    isRunning = false;
                }
                default -> System.out.println("Invalid command");
            }
        }
    }



    
}