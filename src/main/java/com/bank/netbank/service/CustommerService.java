package com.bank.netbank.service;

import com.bank.netbank.dto.CustommerDTO;
import com.bank.netbank.model.Custommer;
import com.bank.netbank.repository.CustommerRepository;
import com.bank.netbank.service.exceptions.DataBaseException;
import com.bank.netbank.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustommerService {


    @Autowired
    CustommerRepository repository;

    @Transactional(readOnly = true)
    public Page<CustommerDTO> findAllPaged(Pageable pageable) {
        Page<Custommer> list = repository.findAll(pageable);
        return list.map(x -> new CustommerDTO(x));

    }

    @Transactional(readOnly = true)
    public CustommerDTO findById(Long id) {

        Optional<Custommer> obj = repository.findById(id);
        Custommer entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found, id: " + id));

        return new CustommerDTO(entity);
    }

    @Transactional
    public CustommerDTO insert(CustommerDTO dto) {
        Custommer entity = new Custommer();
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity = repository.save(entity);
        return new CustommerDTO(entity);
    }

    @Transactional
    public CustommerDTO update(Long id, CustommerDTO dto) {
        try {
            Custommer entity = repository.getReferenceById(id);
            entity.setName(dto.getName());
            entity.setCpf(dto.getCpf());
            entity = repository.save(entity);
            return new CustommerDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not Found " + id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not Found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation ");
        }

    }
}
