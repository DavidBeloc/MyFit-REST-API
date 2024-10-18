package com.davdev.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ExerciseCreateEditDto(@NotNull Long workoutId,
                                    @NotBlank @Size(min = 3) String name,
                                    Double weight,
                                    Double distance,
                                    String report,
                                    Short repeat) {
}