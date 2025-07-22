package com.db.hackathon.credit_api.service;

import com.db.hackathon.credit_api.dto.ChatRequest;
import com.db.hackathon.credit_api.dto.ChatResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;

@Service
public class ChatbotService {

    private final String apiKey;
    private final RestTemplate restTemplate;

    public ChatbotService(@Value("${openai.api-key}") String apiKey) {
        this.apiKey = apiKey;
        this.restTemplate = new RestTemplate();
    }

    public ChatResponse getChatReply(ChatRequest chatRequest) {
        // You can customize the system prompt as needed
        String systemPrompt = "You are a helpful financial assistant and credit advisor. Always reply in the language used by the user.\r\n" + //
                        "";
        Map<String, Object> body = Map.of(
            "model", "gpt-4o-mini",
            "messages", List.of(
                Map.of("role", "system", "content", systemPrompt),
                Map.of("role", "user", "content", chatRequest.message())
            ),
            "max_tokens", 150
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(
            "https://api.openai.com/v1/chat/completions", request, Map.class
        );

        // Parse reply
        String reply = "";
        if (response.getStatusCode().is2xxSuccessful()) {
            List<?> choices = (List<?>) response.getBody().get("choices");
            if (choices != null && !choices.isEmpty()) {
                Map<?, ?> message = (Map<?, ?>) ((Map<?, ?>) choices.get(0)).get("message");
                reply = (String) message.get("content");
            }
        } else {
            reply = "Sorry, I couldn't process your request at the moment.";
        }
        return new ChatResponse(reply.trim());
    }
}

