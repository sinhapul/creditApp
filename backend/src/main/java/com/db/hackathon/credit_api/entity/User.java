package com.db.hackathon.credit_api.entity;

import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userid", nullable = false, unique = true)
    private String userId;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    private String password;

    private String email;

    private Integer age;

    private String location;

    private String gender;

    @Column(name = "water_bill", precision = 10, scale = 2)
    private Integer waterBill;

    @Column(name = "electricity_bill", precision = 10, scale = 2)
    private Integer electricityBill;

    @Column(name = "property_papers")
    private Integer propertyPapers;

    @Column(name = "credit_score")
    private Integer creditScore;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Loan> loans;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Transaction> transactions;
    
}
