package com.example.users.service;


import com.example.users.dto.UserDto;
import com.example.users.entity.UserEntity;
import com.example.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<UserDto> getAllByIds(List<Long> ids){
        return repository.findAllById(ids).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private UserDto toDto(UserEntity entity){
        return UserDto.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .build();
    }

}
