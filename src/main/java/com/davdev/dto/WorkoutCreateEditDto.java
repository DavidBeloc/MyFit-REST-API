package com.davdev.dto;

import java.time.LocalDate;

public record WorkoutCreateEditDto(Long userId,
                                   LocalDate date) {
}
