package com.citi.transactions.controller;

import com.citi.transactions.model.Tax;
import com.citi.transactions.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taxes")
public class TaxController {
    @Autowired
    private TaxService taxService;

    @PostMapping
    public ResponseEntity<Tax> createTax(@RequestBody Tax tax) {
        return new ResponseEntity<>(taxService.createTax(tax), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Tax> getTaxes() {
        return taxService.getAllTaxes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tax> getTax(@PathVariable Long id) {
        return taxService.getTaxById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
