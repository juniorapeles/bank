package com.bank.netbank.service;

import com.bank.netbank.dto.CheckingAccountDTO;
import com.bank.netbank.dto.SavingsAccountDTO;
import com.bank.netbank.model.Account;
import com.bank.netbank.model.CheckingAccount;
import com.bank.netbank.model.SavingsAccount;
import com.bank.netbank.repository.CheckingAccountRepository;
import com.bank.netbank.repository.SavingsAccountRepository;
import com.bank.netbank.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    @Autowired
    CheckingAccountRepository checkingAccountRepository;
    @Autowired
    SavingsAccountRepository savingsAccountRepository;

    @Transactional
    public CheckingAccountDTO createCheckingAccount(CheckingAccountDTO dto ) {
        CheckingAccount entity = new CheckingAccount();
        entity.setOverdraftLimit(dto.getOverdraftLimit());
        checkingAccountRepository.save(entity);
        return new CheckingAccountDTO(entity);
    }

    @Transactional
    public SavingsAccountDTO createSavingsAccount(SavingsAccountDTO dto) {
        SavingsAccount entity = new SavingsAccount();
        entity.setInterestRate(dto.getInterestRate());
        savingsAccountRepository.save(entity);
        return new SavingsAccountDTO(entity);
    }

    @Transactional
    public CheckingAccountDTO depositToCheckingAccount(CheckingAccountDTO dto) {

        try {
            CheckingAccount entity = checkingAccountRepository.getReferenceById(dto.getId());
            entity.deposit(dto.getAmount());
            return new CheckingAccountDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not Found " + dto.getId());
        }

    }
}
