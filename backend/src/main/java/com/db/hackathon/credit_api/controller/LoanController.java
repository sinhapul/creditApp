package com.db.hackathon.credit_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.hackathon.credit_api.dto.LoanAdjustRequest;
import com.db.hackathon.credit_api.dto.LoanAdjustResponse;
import com.db.hackathon.credit_api.dto.LoanAssessRequest;
import com.db.hackathon.credit_api.dto.LoanAssessResponse;
import com.db.hackathon.credit_api.dto.LoanInitializeRequest;
import com.db.hackathon.credit_api.dto.LoanInitializeResponse;
import com.db.hackathon.credit_api.dto.LoanStatusResponse;
import com.db.hackathon.credit_api.dto.PaymentScheduleRequest;
import com.db.hackathon.credit_api.dto.PaymentScheduleResponse;
import com.db.hackathon.credit_api.service.CreditScoringService;
import com.db.hackathon.credit_api.service.LoanService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/loan")
@RequiredArgsConstructor
public class LoanController {

    private final CreditScoringService creditScoringService;
    private final LoanService loanService;

     @PostMapping("/assess")
    public ResponseEntity<LoanAssessResponse> assessLoan(@RequestBody LoanAssessRequest request) {
        LoanAssessResponse response = creditScoringService.assessLoan(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/initialize")
    public ResponseEntity<LoanInitializeResponse> initializeLoan(@RequestBody LoanInitializeRequest request) {
        LoanInitializeResponse response = loanService.initializeLoan(request);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/status/{loanId}")
    public ResponseEntity<LoanStatusResponse> getLoanStatus(@PathVariable Long loanId) {
        LoanStatusResponse response = loanService.getLoanStatus(loanId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/schedule")
    public ResponseEntity<PaymentScheduleResponse> schedulePayment(@RequestBody PaymentScheduleRequest request) {
        PaymentScheduleResponse response = loanService.schedulePayment(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/adjust/{loanId}")
    public ResponseEntity<LoanAdjustResponse> adjustLoan(@PathVariable Long loanId, @RequestBody LoanAdjustRequest request) {
        LoanAdjustResponse response = loanService.adjustLoan(loanId, request);
        return ResponseEntity.ok(response);
    }

    
}
