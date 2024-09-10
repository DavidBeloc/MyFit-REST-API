package com.davdev.dto;

public record ExerciseCreateEditDto(Long workoutId,
                                    String name,
                                    Double weight,
                                    Double distance,
                                    String report,
                                    Short repeat) {
}