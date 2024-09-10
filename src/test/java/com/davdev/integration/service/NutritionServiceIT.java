package com.davdev.integration.service;

import com.davdev.dto.NutritionCreateEditDto;
import com.davdev.integration.IntegrationTestBase;
import com.davdev.service.NutritionService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class NutritionServiceIT extends IntegrationTestBase {

    private final NutritionService nutritionService;

    @Test
    void findByUserIdAndDate() {
        var nutrition = nutritionService.findByUserIdAndDate(1L, LocalDate.of(2024, 8, 20));
        assertThat(nutrition).isPresent();
        assertThat(nutrition.get().id()).isEqualTo(1L);
        assertThat(nutrition.get().user().name()).isEqualTo("David");
    }

    @Test
    void findById() {
        var byId = nutritionService.findById(1L);
        assertThat(byId).isPresent();
    }

    @Test
    void update() {
        var nutritionDto = new NutritionCreateEditDto(
                (short) 120,
                (short) 1110,
                (short) 30,
                LocalDate.of(2024, 8, 20),
                1L
        );
        var actual = nutritionService.update(1L, nutritionDto);
        assertThat(actual).isPresent();
        assertThat(actual.get().protein()).isEqualTo((short) 120);
    }
}

//    var userDto = new UserCreateEditDto("user@gmail.com",
//            "test",
//            LocalDate.now(),
//            "David",
//            "Belot",
//            Role.USER,
//            COMPANY_ID,
//            new MockMultipartFile("test", new byte[0]));
//    var actual = userService.update(USER_ID, userDto);
//    assertTrue(actual.isPresent());
//        actual.ifPresent(user -> {
//        assertEquals(userDto.getUsername(), user.getUsername());
//        assertEquals(userDto.getFirstname(), user.getFirstname());
//        assertEquals(userDto.getLastname(), user.getLastname());
//        assertEquals(userDto.getBirthDate(), user.getBirthDate());
//        assertSame(userDto.getRole(), user.getRole());
//        assertEquals(userDto.getCompanyId(), user.getCompany().getId());
