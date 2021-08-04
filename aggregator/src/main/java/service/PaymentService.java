package service;

import com.example.aggregator.client.DataClient;
import com.example.aggregator.client.UserClient;
import com.example.aggregator.dto.PaymentResponseDto;
import com.example.aggregator.dto.ResponseDto;
import com.example.aggregator.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PaymentService {

    private final DataClient dataClient;
    private final UserClient userClient;

    public List<PaymentResponseDto> getAll() {
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
