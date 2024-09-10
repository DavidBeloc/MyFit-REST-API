package com.davdev.dto;

import com.davdev.database.entity.Gender;

import java.time.LocalDate;

public record UserCreateEditDto(String username,
                                String name,
                                Gender gender,
                                LocalDate birthDate,
                                Double weight) {
}
