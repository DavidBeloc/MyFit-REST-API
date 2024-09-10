package com.davdev.mapper;

import com.davdev.database.entity.User;
import com.davdev.dto.UserReadDto;
import org.springframework.stereotype.Component;

@Component
public class UserReadMapper implements Mapper<User, UserReadDto> {

    @Override
    public UserReadDto map(User object) {
        return new UserReadDto(
                object.getId(),
                object.getUsername(),
                object.getName(),
                object.getGender(),
                object.getBirthDate(),
                object.getWeight());
    }
}
