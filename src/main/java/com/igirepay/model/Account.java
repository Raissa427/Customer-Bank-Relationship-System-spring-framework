package com.igirepay.model;

public class Account {
    private String accountNumber;
    private double balance;
    private String type;
    
    public Account(String accountNumber, double balance, String type) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.type = type;
    }
    
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public String getType() { return type; }
    
    public void deposit(double amount) {
        balance += amount;
    }
    
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new RuntimeException("Insufficient balance");
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", type='" + type + '\'' +
                '}';
    }
}
