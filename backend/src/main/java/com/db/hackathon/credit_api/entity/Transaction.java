package com.db.hackathon.credit_api.entity;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_id", nullable = false)
    private Loan loan;

    @Column(name = "due_date", nullable = false)
    private LocalDateTime duDate;

    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;

    @Column(name = "paid_on_time", nullable = false)
    private boolean paidOnTime;

    @Column(name = "scheduled_amount", nullable = false)
    private BigDecimal scheduledAmount;

    @Column(name = "amount_paid", nullable = false)
    private BigDecimal amountPaid;

    @Column(name = "principal_component", nullable = false)
    private BigDecimal principalComponent;

    @Column(name = "interest_component", nullable = false)
    private BigDecimal interestComponent;

    @Column(name = "late_fee", nullable = false)
    private BigDecimal lateFee;

    @Column(name = "previous_balance", nullable = false)
    private BigDecimal previousBalance;

    @Column(name = "remaining_balance", nullable = false)
    private BigDecimal remainingBalance;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(name = "payment_reference", nullable = false)
    private String paymentReference;

    @Column(nullable = false)
    private String currency;

    private String location;

    private String notes;

    @Column(name = "category_label", nullable = false)
    private String categoryLabel;

}
