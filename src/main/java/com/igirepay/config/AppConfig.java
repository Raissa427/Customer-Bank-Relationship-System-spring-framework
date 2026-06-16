package com.igirepay.config;

import com.igirepay.model.Account;
import com.igirepay.model.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.igirepay")
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean(name = "savings")
    public Account savingsAccount() {
        return new Account("SAV001", 500.0, "Savings");
    }

    @Bean(name = "current")
    public Account currentAccount() {
        return new Account("CUR001", 800.0, "Current");
    }

    @Bean
    public Customer defaultCustomer() {
        return new Customer("CUST001", "Alice", "alice@igirepay.com");
    }
}
