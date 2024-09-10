package com.davdev.mapper;

import com.davdev.database.entity.Workout;
import com.davdev.dto.WorkoutReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class WorkoutReadMapper implements Mapper<Workout, WorkoutReadDto> {

    private final UserReadMapper userReadMapper;

    @Override
    public WorkoutReadDto map(Workout object) {
        var userReadDto = Optional.ofNullable(object.getUser())
                .map(userReadMapper::map)
                .orElse(null);
        return new WorkoutReadDto(object.getId(), userReadDto, object.getDate());
    }
}