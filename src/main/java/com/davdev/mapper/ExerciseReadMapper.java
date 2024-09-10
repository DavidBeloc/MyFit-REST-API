package com.davdev.mapper;

import com.davdev.database.entity.Exercise;
import com.davdev.dto.ExerciseReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ExerciseReadMapper implements Mapper<Exercise, ExerciseReadDto> {

    private final WorkoutReadMapper workoutReadMapper;

    @Override
    public ExerciseReadDto map(Exercise object) {
        var workoutReadDto = Optional.ofNullable(object.getWorkout())
                .map(workoutReadMapper::map)
                .orElse(null);
        return new ExerciseReadDto(workoutReadDto,
                object.getName(),
                object.getWeight(),
                object.getDistance(),
                object.getReport(),
                object.getRepeat());
    }
}
