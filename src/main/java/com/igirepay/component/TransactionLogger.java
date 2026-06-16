package com.igirepay.component;

import com.igirepay.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionLogger {

    private final Customer activeCustomer;
    private int logCount = 0;

    @Autowired
    public TransactionLogger(Customer activeCustomer) {
        this.activeCustomer = activeCustomer;
    }

    public void log(String action, double amount) {
        logCount++;
        System.out.println("[TransactionLogger] Logged: " + action + " of $" + amount + 
                           " for Customer: " + activeCustomer.getName() + 
                           " (Total Logs: " + logCount + ")");
    }

    public Customer getActiveCustomer() {
        return activeCustomer;
    }

    public int getLogCount() {
        return logCount;
    }

    @Override
    public String toString() {
        return "TransactionLogger{logCount=" + logCount + ", activeCustomer=" + activeCustomer.getName() + "}";
    }
}
