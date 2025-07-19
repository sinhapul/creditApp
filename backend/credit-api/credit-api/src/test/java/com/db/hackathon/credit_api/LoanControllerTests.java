// package com.db.hackathon.credit_api;

// import com.db.hackathon.credit_api.controller.LoanController;
// import com.db.hackathon.credit_api.dto.LoanAssessRequest;
// import com.db.hackathon.credit_api.dto.LoanAssessResponse;
// import com.db.hackathon.credit_api.service.LoanService;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mockito;
// import org.springframework.http.ResponseEntity;
// import static org.junit.jupiter.api.Assertions.*;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.*;

// public class LoanControllerTests {

//     private LoanService loanService;
//     private LoanController loanController;

//     @BeforeEach
//     public void setUp() {
//         loanService = Mockito.mock(LoanService.class);
//         loanController = new LoanController(loanService);
//     }

//     @Test
//     public void testApplyForLoan_Success() {
//         LoanRequest request = new LoanRequest();
//         LoanResponse response = new LoanResponse();
//         response.setStatus("APPROVED");

//         when(loanService.applyForLoan(any(LoanRequest.class))).thenReturn(response);

//         ResponseEntity<LoanResponse> result = loanController.applyForLoan(request);

//         assertNotNull(result);
//         assertEquals(200, result.getStatusCodeValue());
//         assertEquals("APPROVED", result.getBody().getStatus());
//         verify(loanService, times(1)).applyForLoan(request);
//     }

//     @Test
//     public void testApplyForLoan_Failure() {
//         LoanRequest request = new LoanRequest();
//         LoanResponse response = new LoanResponse();
//         response.setStatus("REJECTED");

//         when(loanService.applyForLoan(any(LoanRequest.class))).thenReturn(response);

//         ResponseEntity<LoanResponse> result = loanController.applyForLoan(request);

//         assertNotNull(result);
//         assertEquals(200, result.getStatusCodeValue());
//         assertEquals("REJECTED", result.getBody().getStatus());
//         verify(loanService, times(1)).applyForLoan(request);
//     }

//     @Test
//     public void testGetLoanStatus() {
//         long loanId = 123L;
//         LoanResponse response = new LoanResponse();
//         response.setStatus("APPROVED");

//         when(loanService.getLoanStatus(loanId)).thenReturn(response);

//         ResponseEntity<LoanResponse> result = loanController.getLoanStatus(loanId);

//         assertNotNull(result);
//         assertEquals(200, result.getStatusCodeValue());
//         assertEquals("APPROVED", result.getBody().getStatus());
//         verify(loanService, times(1)).getLoanStatus(loanId);
//     }
// }