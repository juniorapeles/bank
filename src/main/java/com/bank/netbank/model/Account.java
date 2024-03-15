package com.bank.netbank.model;

public abstract class Account {
    protected double balance;

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public Double getBalance() {
        return balance;
    }
}

