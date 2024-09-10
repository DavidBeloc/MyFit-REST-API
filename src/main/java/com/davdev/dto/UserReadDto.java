package com.davdev.dto;

import com.davdev.database.entity.Gender;

import java.time.LocalDate;

public record UserReadDto(Long id,
                          String username,
                          String name,
                          Gender gender,
                          LocalDate birthDate,
                          Double weight) {
}