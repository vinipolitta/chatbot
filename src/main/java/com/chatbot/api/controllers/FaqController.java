package com.chatbot.api.controllers;

import com.chatbot.api.dto.MessageRequest;
import com.chatbot.api.dto.Messageresponse;
import com.chatbot.api.services.FaqService;
import com.chatbot.api.utils.FaqAnswers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class FaqController {
    @Autowired
    private FaqService faqService;

    @PostMapping
    public ResponseEntity<Messageresponse> answerQuestion(@RequestBody MessageRequest request) {
        String answer = faqService.getAnswer(request.message());
        Messageresponse response = new Messageresponse(answer);
        return ResponseEntity.ok(response);
    }
}
