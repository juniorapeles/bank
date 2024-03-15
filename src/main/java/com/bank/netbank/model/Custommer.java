package com.bank.netbank.model;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_custommer")
public class Custommer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;


    public Custommer() {
    }

    public Custommer(Long id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;

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
