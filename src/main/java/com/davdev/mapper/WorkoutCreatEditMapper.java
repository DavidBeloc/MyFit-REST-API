package com.davdev.mapper;

import com.davdev.database.entity.User;
import com.davdev.database.entity.Workout;
import com.davdev.database.repository.UserRepository;
import com.davdev.dto.WorkoutCreateEditDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class WorkoutCreatEditMapper implements Mapper<WorkoutCreateEditDto, Workout> {

    private final UserRepository userRepository;

    @Override
    public Workout map(WorkoutCreateEditDto object) {
        Workout workout = new Workout();
        copy(object, workout);
        return workout;
    }

    @Override
    public Workout map(WorkoutCreateEditDto fromObject, Workout toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    private void copy(WorkoutCreateEditDto object, Workout workout) {
        workout.setDate(object.date());
        workout.setUser(getUser(object.userId()));
    }

    private User getUser(Long userId) {
        return Optional.ofNullable(userId)
                .flatMap(userRepository::findById)
                .orElse(null);
    }
}
