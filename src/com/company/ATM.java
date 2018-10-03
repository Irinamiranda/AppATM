package com.company;

import java.util.Scanner;

public class ATM {

    public static void run() {
        //create person object to keep user's information
        Account person = new Account("12345", "Irina", "1234", 500.0);
        //create Scanner object that allows users to make an input
        Scanner s = new Scanner(System.in);

/*
        // ---- initial setup
        System.out.println("Enter your account number");
        String accountNumber = s.nextLine();
        person.setAccountNumber(accountNumber);

        System.out.println("Enter your PIN");
        String pinCode = s.nextLine();
        person.setPinCode(pinCode);

        System.out.println("Enter your name");
        String userName = s.nextLine();
        person.setUserName(userName);

        System.out.println("Enter your balance");
        String balance = s.nextLine();
        person.setBalance(Double.parseDouble(balance));
        // ----
*/

        System.out.println("Starting ATM routine..\n");

        for (int i = 0; i < 3; i++) {
            if (verifyAccount(person)) {
                System.out.println("Welcome to your account, " + person.getUserName());// write your code here
                System.out.println("Your balance is: " + person.getBalance());
                //prompt the user to pick procedure
                System.out.println("Do you wish deposit or withdraw?");
                String choice = " ";

                String answer = s.nextLine();
                //if user picks to deposit
                if (answer.equalsIgnoreCase("deposit")) {
                    System.out.println("What amount are you going to add to your account?");
                    double deposit = s.nextDouble();
                    double totalBalance = person.getBalance() + deposit;
                    person.setBalance(totalBalance);
                    System.out.println("Your balance now is: " + person.getBalance());
                }
                //if user picks to withdraw
                else if (answer.equalsIgnoreCase("withdraw")) {

                    System.out.println("What amount do you wish to withdraw?");
                    double withdraw = s.nextDouble();
                    double totalBalance = person.getBalance() - withdraw;
                    person.setBalance(totalBalance);
                    System.out.println("Your balance now is: " + person.getBalance());
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

    public static boolean verifyAccount(Account account) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter your account number");
        String acc = s.nextLine();
        System.out.println("Enter your PIN code");
        String pin = s.nextLine();

        return account.getAccountNumber().equals(acc) && account.getPinCode().equals(pin);
    }

    public static void main(String[] args) {
        ATM.run();
    }
}
