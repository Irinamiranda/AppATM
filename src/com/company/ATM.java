package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

    public static void run() {
        //create ArrayList to keep all accounts
        ArrayList<Account> accounts = new ArrayList<>();
        //create person object to keep user's information
        Account person = new Account("12345", "Irina", "1234", 500.0);
        accounts.add(person);
        Account person2 = new Account("123456", "Andrey", "123", 200.0);
        accounts.add(person2);
        Account person3 = new Account("1234", "Larissa", "12", 250.0);
        accounts.add(person3);
        //create Scanner object that allows users to make an input
        Scanner s = new Scanner(System.in);


        System.out.println("Starting ATM routine..\n");

        for (int i = 0; i < 3; i++) {
            Account acct = selectAccount(accounts);
            if (acct != null) {
                System.out.println("Welcome to your account, " + acct.getUserName());// write your code here
                System.out.println("Your balance is: " + acct.getBalance());
                //prompt the user to pick procedure
                System.out.println("Do you wish deposit or withdraw?");
                String choice = " ";

                String answer = s.nextLine();
                //if user picks to deposit
                if (answer.equalsIgnoreCase("deposit")) {
                    System.out.println("What amount are you going to add to your account?");
                    double deposit = s.nextDouble();
                    double totalBalance = acct.getBalance() + deposit;
                    acct.setBalance(totalBalance);
                    System.out.println("Your balance now is: " + acct.getBalance());
                }
                //if user picks to withdraw
                else if (answer.equalsIgnoreCase("withdraw")) {

                    System.out.println("What amount do you wish to withdraw?");
                    double withdraw = s.nextDouble();
                    double totalBalance = acct.getBalance() - withdraw;
                    acct.setBalance(totalBalance);
                    System.out.println("Your balance now is: " + acct.getBalance());
                } //if user input wrong answer
                else {
                    System.out.println("Wrong choice! Try again!");
                }
                return;
            }

            if (i < 2) {
                System.out.println("Please try again!");
            }
        }
        System.out.println("Your account is locked");
    }

    // create a method to search the match
    public static Account selectAccount(ArrayList<Account> accounts) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter your account number");
        String acc = s.nextLine();
        System.out.println("Enter your PIN code");
        String pin = s.nextLine();

        for (Account acct : accounts) {
            if (acct.getAccountNumber().equals(acc) && acct.getPinCode().equals(pin)) {
                return acct;
            }
        }

        System.out.println("Account/PIN not found - please create");
        Account newAccount = addNewAccount(acc, pin);
        accounts.add(newAccount);

        return newAccount;
    }

    public static Account addNewAccount(String accountNumber, String pinCode) {
        // -- no account found - create new one
        Account newAcct = new Account();

        Scanner s = new Scanner(System.in);

        System.out.println("Enter your name");
        String userName = s.nextLine();
        newAcct.setUserName(userName);

        System.out.println("Enter your balance");
        String balance = s.nextLine();
        newAcct.setBalance(Double.parseDouble(balance));

        return newAcct;
    }

    public static void main(String[] args) {
        ATM.run();
    }
}
