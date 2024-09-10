package com.davdev.dto;

import java.time.LocalDate;

public record NutritionCreateEditDto(Short protein,
                                     Short carbohydrates,
                                     Short fats,
                                     LocalDate date,
                                     Long userId) {
}
