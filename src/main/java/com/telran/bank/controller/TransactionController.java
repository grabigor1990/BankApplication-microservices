package com.telran.bank.controller;

import com.telran.bank.dto.TransactionDTO;
import com.telran.bank.entity.Transaction;
import com.telran.bank.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionDTO createTransaction(@RequestBody TransactionDTO transactionDTO) {
        return transactionsService.createTransaction(transactionDTO);
    }

    @GetMapping
    public TransactionDTO getTransaction(@PathVariable Long id) {
        return transactionsService.getTransaction(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionDTO> getAllTransactions(@RequestParam(required = false) String date,
                                                   @RequestParam(required = false) String type,
                                                   @RequestParam(required = false) String sort) {
        return transactionsService.getAllTransaction(date, type, sort);
    }
}

