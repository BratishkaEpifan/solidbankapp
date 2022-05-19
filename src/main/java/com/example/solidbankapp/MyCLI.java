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
        String accountType = scanner.nextLine();
        switch (accountType) {
            case "CHECKING" -> { return AccountType.CHECKING; }
            case "FIXED" -> { return  AccountType.FIXED; }
            case "SAVING" -> { return AccountType.SAVING; }
            default -> {
                //System.out.println("Invalid input");
                return null;
            }
        }
    }

    @Override
    public double requestClientAmount() {
        return 0;
    }

    @Override
    public String requestClientAccountNumber() {
        return null;
    }
}
