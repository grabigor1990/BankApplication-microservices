package com.telran.bank.entity;

import com.telran.bank.entity.converter.TransactionConverter;
import com.telran.bank.entity.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "com.telran.bank.generator.UuidTimeSequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "date_time")
    private LocalDate dateTime = LocalDate.now();

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @Convert(converter = TransactionConverter.class)
    private TransactionType type;

    @Column(name = "account_from")
    private String accountFrom;

    @Column(name = "account_to")
    private String accountTo;

    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToMany
    @JoinTable(name = "account_transaction",
            joinColumns = @JoinColumn(name = "transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id"))
    private List<Account> accounts;

    @ManyToOne
    private Account account;

    public Transaction(TransactionType type, String accountFrom, String accountTo, Double amount) {
        this.type = type;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = BigDecimal.valueOf(amount);
    }
}