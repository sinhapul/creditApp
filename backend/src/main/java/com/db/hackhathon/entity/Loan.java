package com.db.hackhathon.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "loans")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private BigDecimal principalAmount;
    private BigDecimal interestRate;
    private String repaymentFrequency;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private LoanStatus status;

    public enum LoanStatus {
        PENDING,
        ACTIVE,
        COMPLETED,
        DEFAULTED
    }
}
