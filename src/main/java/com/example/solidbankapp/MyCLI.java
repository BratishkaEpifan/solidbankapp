/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.solidbankapp;
import java.util.Scanner;
import com.example.solidbankapp.BankAccount.AccountType;
/**
 *
 * @author john_
 */
public class MyCLI implements CLIUI {
    private Scanner scanner;

    public MyCLI(Scanner scanner) {
        this.scanner = scanner;
    }

    public MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    public Scanner getScanner () {
        return scanner;
    }

    public AccountType requestAccountType() throws IllegalArgumentException {
        System.out.println("Please enter account type");
        System.out.println("[CHECKING, SAVING, FIXED]");
        String accountType = scanner.nextLine();
        switch (accountType) {
            case "CHECKING" -> { return AccountType.CHECKING; }
            case "FIXED" -> { return  AccountType.CHECKING; }
            case "SAVING" -> { return AccountType.CHECKING; }
            default -> {
                System.out.println("Invalid input");
                return null;
            }
        }
    }
}
