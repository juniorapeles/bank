package com.bank.netbank.model;

public interface  Account {
    void deposit(double amount);

    void withdraw(double amount);

    Double getBalance();
}
