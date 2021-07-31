package com.example.aggregator.client;

import com.example.aggregator.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "users")
public interface UserClient {

    @GetMapping
    List<UserDto> getAllSendersByIds(@RequestParam List<Long> ids);

}
