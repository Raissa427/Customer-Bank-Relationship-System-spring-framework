package com.igirepay.service;

import com.igirepay.model.Account;
import com.igirepay.model.Customer;
import com.igirepay.model.Transaction;
import com.igirepay.component.TransactionLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankManager {
    private List<Customer> customers = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

    @Autowired
    private Customer injectedCustomer;

    @Autowired
    @Qualifier("savings")
    private Account savingsAccount;

    @Autowired
    @Qualifier("current")
    private Account currentAccount;

    @Autowired
    private TransactionLogger logger;

    public void printInjectedDependencies() {
        System.out.println("\n=== VERIFICATION: All dependencies injected ===");
        System.out.println("Customer bean injected: " + injectedCustomer);
        System.out.println("Savings Account injected: " + savingsAccount);
        System.out.println("Current Account injected: " + currentAccount);
        System.out.println("TransactionLogger injected: " + logger);
    }

    public Customer registerCustomer(String name, String email) {
        Customer c = new Customer("CUST001", name, email);
        customers.add(c);
        return c;
    }
    
    public void deposit(Account account, double amount) {
        account.deposit(amount);
        transactions.add(new Transaction("DEPOSIT", amount));
        logger.log("DEPOSIT", amount);
    }
    
    public void withdraw(Account account, double amount) {
        account.withdraw(amount);
        transactions.add(new Transaction("WITHDRAWAL", amount));
        logger.log("WITHDRAWAL", amount);
    }
    
    public List<Customer> getAllCustomers() {
        return customers;
    }
    
    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    public Customer getInjectedCustomer() {
        return injectedCustomer;
    }

    public Account getSavingsAccount() {
        return savingsAccount;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public TransactionLogger getLogger() {
        return logger;
    }
}
