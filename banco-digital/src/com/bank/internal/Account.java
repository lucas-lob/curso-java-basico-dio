package com.bank.internal;

import java.util.List;
import java.util.Optional;

public abstract class Account {

    private double balance = 0;
    private final String agency;
    private final String account;

    public Account(String agency, String account) {
        this.agency = agency;
        this.account = account;
    }

    public void registerAccountInBank() {
        Bank.addAccount(this);
    }

    public void deposit(double value) {
        balance += value;
    }

    public boolean withdraw(double value) {
        if (value <= this.balance) {
            this.balance -= value;
            return true;
        } else {
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAgency() {
        return agency;
    }

    public String getAccount() {
        return account;
    }

    public boolean transfer(String destinationAccount, String destinationAgency, double value) {
        if (value <= this.balance) {
            List<Account> bankAccounts = Bank.getAccounts();

            Optional<Account> optionalDestinationAccount = bankAccounts.stream()
                    .filter(bankAccount -> {
                        return destinationAccount.equals(bankAccount.getAccount()) && destinationAgency.equals(bankAccount.getAgency());
                    })
                    .findFirst();

            this.withdraw(value);
            optionalDestinationAccount.get().deposit(value);
            
            return true;
        } else {
            return false;
        }
    }
}
