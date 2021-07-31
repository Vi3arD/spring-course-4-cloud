package com.example.users.controller;

import com.example.users.dto.UserDto;
import com.example.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public List<UserDto> getAllPayments(@RequestParam List<Long> ids) {
        return service.getAllByIds(ids);
    }

}
