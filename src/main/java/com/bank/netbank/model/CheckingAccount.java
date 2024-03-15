package com.bank.netbank.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_checkingAccount")
public class CheckingAccount implements Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double balance;
    private double overdraftLimit;

    public CheckingAccount() {
    }

    public CheckingAccount(double overdraftLimit){
        balance = 0.0;
        this.overdraftLimit = overdraftLimit;
    }


    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if(amount <= balance + overdraftLimit){
            balance -= amount;
        }else{
            System.out.println("Withdrawal amount exceeds available balance + overdraft limit.");
        }
    }

    @Override
    public Double getBalance() {
        return balance;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "id=" + id +
                ", balance=" + balance +
                ", overdraftLimit=" + overdraftLimit +
                '}';
    }


}
