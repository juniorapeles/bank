package com.bank.netbank.dto;

import com.bank.netbank.model.CheckingAccount;

public class CheckingAccountDTO {
    private Long id;
    private double overdraftLimit;

    public CheckingAccountDTO() {
    }

    public CheckingAccountDTO(Long id, double overdraftLimit) {
        this.id = id;
        this.overdraftLimit = overdraftLimit;
    }

    public CheckingAccountDTO(CheckingAccount entity) {
        id = entity.getId();
        overdraftLimit = entity.getOverdraftLimit();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}
