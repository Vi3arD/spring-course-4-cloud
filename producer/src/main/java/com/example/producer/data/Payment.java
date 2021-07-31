package com.example.producer.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Payment implements Payload {
  private long id;
  private long senderId;
  private long amount;
  private String comment;
}
