package com.company;

import java.util.Scanner;
import java.util.ArrayList;

public class ATM {

    public static void main(String[] args) {
        //create an ArrayList to save all transactions
        ArrayList<String> myArray = new ArrayList<>();
        //create person object to keep user's information
        Account person = new Account();
        //create Scanner object that allows users to make an input
        Scanner s = new Scanner(System.in);

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
        Double balance = s.nextDouble();

        person.setBalance(balance);

        System.out.println("Enter your account number");
        String number1 = s.nextLine();
        System.out.println("Enter your PIN code");
        String number2 = s.nextLine();


        if (number1.equalsIgnoreCase(person.getAccountNumber()) && number2.equalsIgnoreCase(person.getPinCode())) {

            System.out.println("Welcome to your account, " + person.getUserName());// write your code here
            System.out.println("Your balance is: " + person.getBalance());
            //prompt the user to pick procedure
            System.out.println("Do you wish deposit or withdraw?");
            String choice = " ";

            String answer = s.nextLine();
            //if user picks to deposit
            if (answer.equalsIgnoreCase("deposit")) {

                System.out.println("What amount are you going to add to your account?");
                double deposite = s.nextDouble();
                double totalBalance = person.getBalance() + deposite;
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
            //if account number and PIN code do not match
        } else { //loop allows user to make 3 attempts.
            for (int i = 0; i < 3; i++) {
                System.out.println("Please try again!");

            }
            System.out.println("Your account is locked");
        }


    }
}
