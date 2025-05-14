package com.bank.external;

import com.bank.internal.Account;
import com.bank.internal.CurrentAccount;
import com.bank.internal.SavingsAccount;

public class Client {

    private String name;
    private Account currentAccount;
    private Account savingsAccount;

    public Client(String name) {
        this.name = name;
    }

    public void createCurrentAccount(String agency, String account) {
        this.currentAccount = new CurrentAccount(agency, account);
        this.currentAccount.registerAccountInBank();
    }

    public void createSavingsAccount(String agency, String account) {
        this.savingsAccount = new SavingsAccount(agency, account);
        this.savingsAccount.registerAccountInBank();
    }

    public double getCurrentAccountBankStatement() {
        return currentAccount.getBalance();
    }

    public double getSavingsAccountBankStatement() {
        return savingsAccount.getBalance();
    }

    public void deposit(int accountOption, double value) {
        switch (accountOption) {
            case 1 -> {
                currentAccount.deposit(value);
            }
            default -> {
                savingsAccount.deposit(value);
            }
        }
    }

    public boolean withdraw(int accountOption, double value) {
        switch (accountOption) {
            case 1 -> {
                return currentAccount.withdraw(value);
            }
            default -> {
                return savingsAccount.withdraw(value);
            }
        }
    }

    public boolean transfer(int option, String account, String agency, double value) {
        switch (option) {
            case 1 -> {
                return currentAccount.transfer(account, agency, value);
            }
            default -> {
                return savingsAccount.transfer(account, agency, value);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
