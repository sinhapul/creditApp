package com.db.hackathon.credit_api.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.db.hackathon.credit_api.entity.Transaction;
import com.db.hackathon.credit_api.entity.User;
import com.db.hackathon.credit_api.helper.RecordLoader;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@Service
public class OpenAIClient {

    private static final String OPENAI_URL = "https://api.openai.com/v1/chat/completions";

    private final RestTemplate rest;

    private String apiKey;

    @Autowired
    private final RecordLoader recordLoader;

    public OpenAIClient(@Value("${ayush}") String apiKey, RecordLoader recordLoader) {
        this.rest = new RestTemplate();
        this.apiKey = apiKey;
        this.recordLoader = recordLoader;
    }

    public int getCreditScore(User user, List<Transaction> txns) {

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> system = Map.of(
            "role", "system",
            "content", """
                You are a credit-scoring assistant.  You will receive:
              • profile: { id, name, phoneNumber, email }
              • transactions: [ { due_date, payment_date, paid_on_time, scheduled_amount,
                                 amount_paid, principal_component, interest_component,
                                 late_fee, previous_balance, remaining_balance,
                                 payment_method, payment_reference, currency, location, notes } ]

            Scoring rules (example):
              • On-time repayment: + (amount_paid ÷ 50)
              • Late repayment:     - 50
              • Scheduled expense:  - (scheduled_amount ÷ 200)
              • Income or over-payment: + (amount_paid ÷ 100)
              • Cap score between 0 and 900

            Respond with exactly:
            {
              "creditScore": <integer between 0 and 900>
            }
                    """
        );

        Map<String, Object> userMasg = Map.of(
            "role", "user",
            "content", Map.of(
                "profile", Map.of(
                    "id", user.getId(),
                    "name", user.getUserId(),
                    "phoneNumber", user.getPhoneNumber(),
                    "email", user.getEmail()
                ),
                "transactions", txns.stream()
                    .map((Transaction tx) -> {
                        Map<String, Object> txnMap = new HashMap<>();
                        txnMap.put("due_date", tx.getDuDate());
                        txnMap.put("payment_date", tx.getPaymentDate());
                        txnMap.put("paid_on_time", tx.isPaidOnTime());
                        txnMap.put("scheduled_amount", tx.getScheduledAmount());
                        txnMap.put("amount_paid", tx.getAmountPaid());
                        txnMap.put("principal_component", tx.getPrincipalComponent());
                        txnMap.put("interest_component", tx.getInterestComponent());
                        txnMap.put("late_fee", tx.getLateFee());
                        txnMap.put("previous_balance", tx.getPreviousBalance());
                        txnMap.put("remaining_balance", tx.getRemainingBalance());
                        txnMap.put("payment_method", tx.getPaymentMethod());
                        txnMap.put("payment_reference", tx.getPaymentReference());
                        txnMap.put("currency", tx.getCurrency());
                        txnMap.put("location", tx.getLocation());
                        txnMap.put("notes", tx.getNotes());
                        return txnMap;
                    })
                    .toList()
            )
        );

        Map<String, Object> body = Map.of(
            "model", "gpt-4o-mini",
            "messages", List.of(system, userMasg),
            "max_tokens", 1000
        );

        HttpEntity<Map<String, Object>> req = new HttpEntity<>(body, headers);
        ResponseEntity<Map> resp = rest.postForEntity(
            OPENAI_URL,
            req,
            Map.class
        );

        String content = (String)((Map)((Map)((List)resp.getBody()
                                              .get("choices")).get(0))
                                    .get("message"))
                           .get("content");
        int parsed = 0;
        try {
            parsed = new com.fasterxml.jackson.databind.ObjectMapper()
                        .readTree(content).get("creditScore").asInt();
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            throw new RuntimeException("Failed to parse credit score from OpenAI response", e);
        }

        return parsed;

    }

    public int getCreditScore() throws IOException {

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);


        String trainingData = recordLoader.getExamplesAsPrompt();

        Map<String, Object> system = Map.of(
            "role", "system",
            "content", String.format("""
            You are a credit-scoring assistant.  You will receive:
              • profile: { age, gender, location, EC Bill, EC Bill Amount }

            Give a score between 0 and 900 based on the following training data:

            %s

            Respond with exactly:
            {
              "creditScore": <integer between 0 and 900>
            }
            
            The training data is a set of examples that you can use to understand how to score the user.
            Each example is formatted as follows:
                """, trainingData)
        );

        String inputPrompt = String.format("""
            Age: %d
            gender: %s
            Location: %s
            ec bill: %s
            ec bill amount: %s
            Output: Credit Score:
            """, 80, "Male", "Bangalore", "11127", "122");


        Map<String, Object> userMasg = Map.of(
            "role", "user",
            "content", inputPrompt
        );

        Map<String, Object> body = Map.of(
            "model", "gpt-4o-mini",
            "messages", List.of(system, userMasg),
            "max_tokens", 1000
        );

        HttpEntity<Map<String, Object>> req = new HttpEntity<>(body, headers);
        ResponseEntity<Map> resp = rest.postForEntity(
            OPENAI_URL,
            req,
            Map.class
        );

        String content = (String)((Map)((Map)((List)resp.getBody()
                                              .get("choices")).get(0))
                                    .get("message"))
                           .get("content");
        int parsed = 0;
        try {
            parsed = new com.fasterxml.jackson.databind.ObjectMapper()
                        .readTree(content).get("creditScore").asInt();
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            throw new RuntimeException("Failed to parse credit score from OpenAI response", e);
        }

        return parsed;

    }

    public int getCreditScore(String userId, int age, String gender, String location, Integer electricityBill, Integer waterBill) throws IOException {

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);


        String trainingData = recordLoader.getExamplesAsPrompt();

        Map<String, Object> system = Map.of(
            "role", "system",
            "content", String.format("""
            You are a credit-scoring assistant.  You will receive:
              • profile: { age, gender, location, EC Bill, EC Bill Amount }

            Give a score between 0 and 900 based on the following training data:

            %s

            Respond with exactly:
            {
              "creditScore": <integer between 0 and 900>
            }
            
            The training data is a set of examples that you can use to understand how to score the user.
            Each example is formatted as follows:
                """, trainingData)
        );

        String inputPrompt = String.format("""
            Age: %d
            gender: %s
            Location: %s
            ec bill: %s
            ec bill amount: %s
            Output: Credit Score:
            """, age, gender, location, electricityBill, waterBill);


        Map<String, Object> userMasg = Map.of(
            "role", "user",
            "content", inputPrompt
        );

        Map<String, Object> body = Map.of(
            "model", "gpt-4o-mini",
            "messages", List.of(system, userMasg),
            "max_tokens", 1000
        );

        HttpEntity<Map<String, Object>> req = new HttpEntity<>(body, headers);
        ResponseEntity<Map> resp = rest.postForEntity(
            OPENAI_URL,
            req,
            Map.class
        );

        String content = (String)((Map)((Map)((List)resp.getBody()
                                              .get("choices")).get(0))
                                    .get("message"))
                           .get("content");
        int parsed = 0;
        try {
            parsed = new com.fasterxml.jackson.databind.ObjectMapper()
                        .readTree(content).get("creditScore").asInt();
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            throw new RuntimeException("Failed to parse credit score from OpenAI response", e);
        }

        return parsed;

    }

}
