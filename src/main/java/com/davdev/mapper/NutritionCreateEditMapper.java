package com.davdev.mapper;

import com.davdev.database.entity.Nutrition;
import com.davdev.database.entity.User;
import com.davdev.database.repository.UserRepository;
import com.davdev.dto.NutritionCreateEditDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NutritionCreateEditMapper implements Mapper<NutritionCreateEditDto, Nutrition> {

    private final UserRepository userRepository;

    @Override
    public Nutrition map(NutritionCreateEditDto object) {
        Nutrition nutrition = new Nutrition();
        copy(object, nutrition);
        return nutrition;
    }

    @Override
    public Nutrition map(NutritionCreateEditDto fromObject, Nutrition toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    private void copy(NutritionCreateEditDto object, Nutrition nutrition) {
        nutrition.setProtein(object.protein());
        nutrition.setFats(object.fats());
        nutrition.setCarbohydrates(object.carbohydrates());
        nutrition.setDate(object.date());
        nutrition.setUser(getUser(object.userId()));
    }

    private User getUser(Long userId) {
        return Optional.ofNullable(userId)
                .flatMap(userRepository::findById)
                .orElse(null);
    }
}