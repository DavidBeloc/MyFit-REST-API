package com.davdev.database.repository;

import com.davdev.database.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    Optional<Exercise> findAllByWorkoutId(Long workoutId);
}
