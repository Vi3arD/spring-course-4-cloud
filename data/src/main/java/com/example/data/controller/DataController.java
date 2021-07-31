package com.example.data.controller;

import com.example.data.dto.ResponseDto;
import com.example.data.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DataController {

    private final PaymentService service;

    @GetMapping
    public List<ResponseDto> getAllPayments() {
        return service.getAllPayments();
    }

}
