package com.igirepay;

import com.igirepay.config.AppConfig;
import com.igirepay.model.Account;
import com.igirepay.model.Customer;
import com.igirepay.service.BankManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Starting Spring Bank System ===");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BankManager bankManager = context.getBean(BankManager.class);

        System.out.println();
        Customer customer = bankManager.registerCustomer("Alice", "alice@igirepay.com");
        System.out.println("[SERVICE] Customer registered: " + customer.getName());

        System.out.println();
        Account savings = bankManager.getSavingsAccount();
        System.out.println("[Main] Initial Savings Balance: $" + savings.getBalance());
        bankManager.deposit(savings, 500.0);
        System.out.println("[SERVICE] Deposited $500.0 to Savings Account. New Balance: $" + savings.getBalance());

        System.out.println();
        Account current = bankManager.getCurrentAccount();
        System.out.println("[Main] Initial Current Balance: $" + current.getBalance());
        bankManager.withdraw(current, 200.0);
        System.out.println("[SERVICE] Withdrew $200.0 from Current Account. New Balance: $" + current.getBalance());

        bankManager.printInjectedDependencies();

        System.out.println("\n=== Shutting down Spring Bank System ===");
        context.close();
    }
}
