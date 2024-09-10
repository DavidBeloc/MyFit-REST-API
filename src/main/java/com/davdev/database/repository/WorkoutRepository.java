package com.davdev.database.repository;

import com.davdev.database.entity.Workout;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    List<Workout> findAllByUserIdOrderByDateDesc(Long id, Pageable pageable);

    Optional<Workout> findByUserIdAndDate(Long userId, LocalDate date);

}
