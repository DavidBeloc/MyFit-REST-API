package com.davdev.dto;

import java.time.LocalDate;

public record NutritionReadDto(Long id,
                               Short protein,
                               Short carbohydrates,
                               Short fats,
                               LocalDate date,
                               UserReadDto user) {
}
