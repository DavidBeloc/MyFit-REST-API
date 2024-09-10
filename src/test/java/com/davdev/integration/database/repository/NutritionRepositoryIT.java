package com.davdev.integration.database.repository;

import com.davdev.database.repository.NutritionRepository;
import com.davdev.integration.IntegrationTestBase;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class NutritionRepositoryIT extends IntegrationTestBase {

    private final NutritionRepository nutritionRepository;

    @Test
    void findByUserIdAndDate() {
        var nutrition = nutritionRepository.findByUserIdAndDate(1L, LocalDate.of(2024, 8, 20));
        assertThat(nutrition).isPresent();
        assertThat(nutrition.get().getId()).isEqualTo(1L);
    }
}
