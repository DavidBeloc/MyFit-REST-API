package com.davdev.dto;

public record ExerciseReadDto(WorkoutReadDto workoutReadDto,
                              String name,
                              Double weight,
                              Double distance,
                              String report,
                              Short repeat) {
}