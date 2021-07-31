package com.example.producer.controller;

import com.example.producer.dto.PaymentRequestDto;
import com.example.producer.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @PostMapping
    public void createPost(@RequestBody PaymentRequestDto request) {
        service.send(request);
    }

}
