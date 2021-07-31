package com.example.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResponseDto {
  private long id;
  private long senderId;
  private long amount;
  private String comment;
}
