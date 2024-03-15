package com.bank.netbank.controller;

import com.bank.netbank.dto.CheckingAccountDTO;
import com.bank.netbank.dto.SavingsAccountDTO;
import com.bank.netbank.model.Account;
import com.bank.netbank.model.CheckingAccount;
import com.bank.netbank.model.SavingsAccount;
import com.bank.netbank.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    @Autowired
    AccountService service;

    @PostMapping("/checking")
    public ResponseEntity<CheckingAccountDTO> createCheckingAccount(@RequestBody CheckingAccountDTO dto) {
        dto = service.createCheckingAccount(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PostMapping("/checking/deposit")
    public ResponseEntity<CheckingAccountDTO> depositToCheckingAccount(@RequestBody CheckingAccountDTO dto) {
         dto = service.depositToCheckingAccount(dto);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/savings")
    public ResponseEntity<SavingsAccountDTO> createSavingsAccount(@RequestBody SavingsAccountDTO dto) {
        dto = service.createSavingsAccount(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
