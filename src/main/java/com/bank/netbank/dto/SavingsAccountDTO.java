package com.bank.netbank.dto;

import com.bank.netbank.model.SavingsAccount;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class SavingsAccountDTO {

    private long id;
    private double balance;
    private double interestRate;

    public SavingsAccountDTO() {
    }

    public SavingsAccountDTO(long id, double balance, double interestRate) {
        this.id = id;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public SavingsAccountDTO(SavingsAccount entity) {
         id = entity.getId();
         balance = entity.getBalance();
         interestRate = entity.getInterestRate();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
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
