package com.example.aggregator.controller;

import com.example.aggregator.client.DataClient;
import com.example.aggregator.client.UserClient;
import com.example.aggregator.dto.PaymentResponseDto;
import com.example.aggregator.dto.ResponseDto;
import com.example.aggregator.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final DataClient dataClient;
    private final UserClient userClient;

    @GetMapping
    public List<PaymentResponseDto> payments() {
        List<ResponseDto> payments = dataClient.getAllPayments();
        List<Long> sendersIds = (ArrayList<Long>) payments.stream()
                .map(ResponseDto::getSenderId)
                .distinct()
                .collect(Collectors.toList());
        Map<Long, String> senders = userClient.getAllSendersByIds(sendersIds).stream()
                .collect(Collectors.toMap(UserDto::getId, UserDto::getUsername));

        List<PaymentResponseDto> responses = new ArrayList<>();

        payments.forEach(payment ->
                responses.add(
                        PaymentResponseDto.builder()
                                .id(payment.getId())
                                .sender(senders.get(payment.getSenderId()))
                                .amount(payment.getAmount())
                                .comment(payment.getComment())
                                .build()
                )
        );

        return responses;
    }


}
