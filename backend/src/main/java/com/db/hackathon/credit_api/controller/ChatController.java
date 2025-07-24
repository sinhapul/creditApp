package com.db.hackathon.credit_api.controller;

import com.db.hackathon.credit_api.dto.ChatRequest;
import com.db.hackathon.credit_api.dto.ChatResponse;
import com.db.hackathon.credit_api.service.ChatbotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chat")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ChatController {

    private final ChatbotService chatbotService;

    @PostMapping
    public ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest request) {
        ChatResponse reply = chatbotService.getChatReply(request);
        return ResponseEntity.ok(reply);
    }
}

