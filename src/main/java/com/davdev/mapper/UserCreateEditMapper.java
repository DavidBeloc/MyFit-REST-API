package com.davdev.mapper;

import com.davdev.database.entity.User;
import com.davdev.dto.UserCreateEditDto;
import org.springframework.stereotype.Component;

@Component
public class UserCreateEditMapper implements Mapper<UserCreateEditDto, User> {

    @Override
    public User map(UserCreateEditDto object) {
        User user = new User();
        copy(object, user);
        return user;
    }

    @Override
    public User map(UserCreateEditDto fromObject, User toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    private void copy(UserCreateEditDto object, User user) {
        user.setUsername(object.username());
        user.setName(object.name());
        user.setBirthDate(object.birthDate());
        user.setGender(object.gender());
        user.setWeight(object.weight());

//        Optional.ofNullable(object.rawPassword())
//                .filter(StringUtils::hasText)
//                .map(passwordEncoder::encode)
//                .ifPresent(user::setPassword);
    }
}
