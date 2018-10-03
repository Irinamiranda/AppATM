package com.company;

public class Account {
    private String accountNumber;
    private String userName;
    private String pinCode;
    private double balance;

    public Account() {
    }

    public Account(String accountNumber, String userName, String pinCode, double balance) {
        this.accountNumber = accountNumber;
        this.userName = userName;
        this.pinCode = pinCode;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
