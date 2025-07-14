package com.db.hackhathon.entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) 
    private User user;

    private String description;
    private BigDecimal amount;
    private LocalDateTime timestamp;

    // Label from zero-shot / ML classification: Income, Expense, Repayment, Fraud
    private String categoryLabel;

}
