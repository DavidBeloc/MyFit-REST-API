package com.davdev.database.repository;

import com.davdev.database.entity.Nutrition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface NutritionRepository extends JpaRepository<Nutrition, Long> {

    Optional<Nutrition> findByUserIdAndDate(Long userId, LocalDate date);
}
