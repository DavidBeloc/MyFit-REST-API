package com.davdev.mapper;

import com.davdev.database.entity.Nutrition;
import com.davdev.dto.NutritionReadDto;
import com.davdev.dto.UserReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NutritionReadMapper implements Mapper<Nutrition, NutritionReadDto> {

    private final UserReadMapper userReadMapper;

    @Override
    public NutritionReadDto map(Nutrition object) {
        var userReadDto = Optional.ofNullable(object.getUser())
                .map(userReadMapper::map)
                .orElse(null);
        return new NutritionReadDto(object.getId(),
                object.getProtein(),
                object.getCarbohydrates(),
                object.getFats(),
                object.getDate(),
                userReadDto);
    }
}
