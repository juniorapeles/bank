package com.bank.netbank.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_savingsAccount")
public class SavingsAccount implements Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double balance;
    private double interestRate;

    public SavingsAccount() {
    }

    public SavingsAccount(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= interestRate;
            balance -= amount;
        } else {
            System.out.println("Withdrawal amount exceeds available balance.");
        }
    }
    @Override
    public Double getBalance() {
        return balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
