package com.davdev.mapper;

import com.davdev.database.entity.Exercise;
import com.davdev.database.entity.Workout;
import com.davdev.database.repository.WorkoutRepository;
import com.davdev.dto.ExerciseCreateEditDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ExerciseCreatEditMapper implements Mapper<ExerciseCreateEditDto, Exercise> {

    private final WorkoutRepository workoutRepository;

    @Override
    public Exercise map(ExerciseCreateEditDto object) {
        Exercise exercise = new Exercise();
        copy(object, exercise);
        return exercise;
    }

    @Override
    public Exercise map(ExerciseCreateEditDto fromObject, Exercise toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    private void copy(ExerciseCreateEditDto object, Exercise exercise) {
        exercise.setWorkout(getWorkout(object.workoutId()));
        exercise.setName(object.name());
        exercise.setWeight(object.weight());
        exercise.setDistance(object.distance());
        exercise.setReport(object.report());
        exercise.setRepeat(object.repeat());
    }

    private Workout getWorkout(Long workoutId) {
        return Optional.ofNullable(workoutId)
                .flatMap(workoutRepository::findById)
                .orElse(null);
    }
}
