package com.telran.bank.entity;

import com.telran.bank.entity.enums.TransactionType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@ToString
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "transactionID")
    private Long transactionID;

    @Column(name = "date_time")
    private LocalDateTime dateTime = LocalDateTime.now();

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(name = "account_from")
    private String accoutFrom;

    @Column(name = "account_to")
    private String accountTo;

    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private List<Account>account;
}