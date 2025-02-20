package com.citi.transactions.service;

import com.citi.transactions.model.Tax;
import com.citi.transactions.repository.TaxRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxService {

    private final TaxRepository taxRepository;

    public TaxService(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }

    public Tax createTax(Tax tax) {
        return taxRepository.save(tax);
    }

    public List<Tax> getAllTaxes() {
        return taxRepository.findAll();
    }

    public Optional<Tax> getTaxById(Long id) {
        return taxRepository.findById(id);
    }
}