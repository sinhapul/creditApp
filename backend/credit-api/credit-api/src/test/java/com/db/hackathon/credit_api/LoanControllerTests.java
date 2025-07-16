// package com.db.hackathon.credit_api;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import org.junit.jupiter.api.*;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.*;

// import java.math.BigDecimal;
// import java.util.Map;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// @SpringBootTest
// @ExtendWith(MockitoExtension.class)
// @TestInstance(TestInstance.Lifecycle.PER_CLASS)
// @AutoConfigureMockMvc(addFilters = false) // disables security filters for tests
// class LoanControllerTests {
//     @Autowired
//     private MockMvc mockMvc;

//     @Autowired
//     private ObjectMapper objectMapper;

//     // will hold the loanId created in testInitializeLoan()
//     private static Long createdLoanId;

//     @Test
//     @Order(1)
//     void testAssessLoan() throws Exception {
//         Map<String, Object> req = Map.of(
//             "userId", 1L,
//             "paymentAppId", "PhonePe",
//             "requestedAmount", new BigDecimal("5000"),
//             "existingObligations", new BigDecimal("0")
//         );

//         mockMvc.perform(post("/api/v1/loan/assess")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(objectMapper.writeValueAsString(req)))
//             .andExpect(status().isOk())
//             .andExpect(jsonPath("$.creditScore").isNumber())
//             .andExpect(jsonPath("$.eligibleAmount").isNumber())
//             .andExpect(jsonPath("$.interestRate").isNumber())
//             .andExpect(jsonPath("$.repaymentFrequency").isString());
//     }

//     @Test
//     @Order(2)
//     void testInitializeLoan() throws Exception {
//         var bankDetails = Map.of(
//             "accountNumber", "1234567890",
//             "ifsc", "IFSC0001"
//         );
//         Map<String, Object> req = Map.of(
//             "userId", 1L,
//             "paymentAppId", "PhonePe",
//             "loanAmount", new BigDecimal("5000"),
//             "preferredFrequency", "weekly",
//             "creditScore", new BigDecimal("700"),
//             "bankDetails", bankDetails
//         );

//         MvcResult result = mockMvc.perform(post("/api/v1/loan/initialize")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(objectMapper.writeValueAsString(req)))
//             .andExpect(status().isOk())
//             .andExpect(jsonPath("$.loanId").isNumber())
//             .andExpect(jsonPath("$.status").value("ACTIVE"))
//             .andReturn();

//         Map<String, Object> resp = objectMapper.readValue(
//             result.getResponse().getContentAsString(), Map.class);
//         createdLoanId = ((Number) resp.get("loanId")).longValue();
//     }

//     @Test
//     @Order(3)
//     void testGetStatus() throws Exception {
//         mockMvc.perform(get("/api/v1/loan/status/{id}", createdLoanId))
//             .andExpect(status().isOk())
//             .andExpect(jsonPath("$.loanId").value(createdLoanId))
//             .andExpect(jsonPath("$.status").isString())
//             .andExpect(jsonPath("$.principalAmount").isNumber())
//             .andExpect(jsonPath("$.repaymentFrequency").isString());
//     }

//     @Test
//     @Order(4)
//     void testSchedulePayment() throws Exception {
//         Map<String, Object> req = Map.of(
//             "loanId", createdLoanId,
//             "newFrequency", "daily",
//             "adjustmentReason", "Switching to daily payments"
//         );

//         mockMvc.perform(post("/api/v1/loan/schedule")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(objectMapper.writeValueAsString(req)))
//             .andExpect(status().isOk())
//             .andExpect(jsonPath("$.loanId").value(createdLoanId))
//             .andExpect(jsonPath("$.repaymentFrequency").value("daily"));
//     }

//     @Test
//     @Order(5)
//     void testAdjustLoan() throws Exception {
//         Map<String, Object> req = Map.of(
//             "newInterestRate", new BigDecimal("5.5")
//         );

//         mockMvc.perform(put("/api/v1/loan/adjust/{id}", createdLoanId)
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(objectMapper.writeValueAsString(req)))
//             .andExpect(status().isOk())
//             .andExpect(jsonPath("$.loanId").value(createdLoanId))
//             .andExpect(jsonPath("$.interestRate").value(5.5));
//     }
// }