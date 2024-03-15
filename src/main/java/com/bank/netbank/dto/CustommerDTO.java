package com.bank.netbank.dto;

import com.bank.netbank.model.Custommer;

public class CustommerDTO {
    private Long id;
    private String name;
    private String cpf;


    public CustommerDTO() {
    }

    public CustommerDTO(Long id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }

    public CustommerDTO(Custommer entity) {
        id = entity.getId();
        name = entity.getName();
        cpf = entity.getCpf();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
