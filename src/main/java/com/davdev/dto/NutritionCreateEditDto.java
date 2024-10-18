package com.davdev.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record NutritionCreateEditDto(Short protein,
                                     Short carbohydrates,
                                     Short fats,
                                     LocalDate date,
                                     @NotNull Long userId) {
}
