package com.bank.netbank.model;

public class CheckingAccount implements Account{
    private double balance;
    private double overdraftLimit;

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
}
