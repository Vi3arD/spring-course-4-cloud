package com.example.aggregator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDto {
    private long id;
    private long senderId;
    private long amount;
    private String comment;
}
