package com.davdev.dto;

import java.time.LocalDate;

public record WorkoutReadDto(Long id,
                             UserReadDto userReadDto,
                             LocalDate date) {
}
