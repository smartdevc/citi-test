package com.citi.transactions.repository;

import com.citi.transactions.model.Tax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxRepository extends JpaRepository<Tax, Long> {}