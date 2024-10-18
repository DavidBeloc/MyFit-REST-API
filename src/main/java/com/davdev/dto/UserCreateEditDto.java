package com.davdev.dto;

import com.davdev.database.entity.Gender;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserCreateEditDto(@Email @NotBlank @Size(max = 40) String username,
                                @NotBlank @Size(min = 4, max = 30) String name,
                                Gender gender,
                                @Past LocalDate birthDate,
                                @NotNull Double weight) {
}
