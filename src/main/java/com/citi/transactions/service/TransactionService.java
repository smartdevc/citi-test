package com.citi.transactions.service;


import com.citi.transactions.model.Tax;
import com.citi.transactions.model.Transaction;
import com.citi.transactions.repository.TaxRepository;
import com.citi.transactions.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TaxRepository taxRepository;

    public TransactionService(TransactionRepository transactionRepository, TaxRepository taxRepository) {
        this.transactionRepository = transactionRepository;
        this.taxRepository = taxRepository;
    }

    public Transaction createTransaction(Double amount) {
        //retrieve the lastest tax for the transaction
        Optional<Tax> latestTax = taxRepository.findAll().stream().reduce((first, second) -> second);
        double taxAmount = latestTax.map(tax -> amount * tax.getRate()).orElse(0.0);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setTaxId(latestTax.map(Tax::getId).orElse(null));
        transaction.setTaxAmount(taxAmount);
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }
}