package com.bank.internal;
import java.util.ArrayList;
import java.util.List;

public abstract class Bank {
    private final static List<Account> accounts = new ArrayList<>();

    static List<Account> getAccounts() {
        return accounts;
    }

    static boolean addAccount(Account account){
        accounts.add(account);
        return true;
    }
}
