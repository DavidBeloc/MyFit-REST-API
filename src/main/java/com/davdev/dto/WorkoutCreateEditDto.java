package com.davdev.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record WorkoutCreateEditDto(@NotNull Long userId,
                                   LocalDate date) {
}
