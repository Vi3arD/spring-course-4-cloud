package com.example.data.service;

import com.example.data.data.Payment;
import com.example.data.dto.ResponseDto;
import com.example.data.entity.PaymentEntity;
import com.example.data.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final Log logger = LogFactory.getLog(this.getClass());
    private final PaymentRepository repository;

    public List<ResponseDto> getAllPayments(){
        return repository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @KafkaListener(groupId = "data-consumer", topics = "processed")
    public void listen(Payment message, ConsumerRecord<String, Payment> record, Acknowledgment acknowledgment) {
        logger.info(message);
        repository.save(dataToEntity(message));
        acknowledgment.acknowledge();
    }

    private PaymentEntity dataToEntity(Payment message) {
        return PaymentEntity.builder()
                .senderId(message.getSenderId())
                .amount(message.getAmount())
                .comment(message.getComment())
                .build();
    }

    private ResponseDto toDto(PaymentEntity entity){
        return ResponseDto.builder()
                .id(entity.getId())
                .senderId(entity.getSenderId())
                .amount(entity.getAmount())
                .comment(entity.getComment())
                .build();
    }

}
