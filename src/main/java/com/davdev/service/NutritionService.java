package com.davdev.service;

import com.davdev.database.repository.NutritionRepository;
import com.davdev.dto.NutritionCreateEditDto;
import com.davdev.dto.NutritionReadDto;
import com.davdev.mapper.NutritionCreateEditMapper;
import com.davdev.mapper.NutritionReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NutritionService {

    private final NutritionRepository nutritionRepository;
    private final NutritionReadMapper nutritionReadMapper;
    private final NutritionCreateEditMapper nutritionCreateEditMapper;

    public Optional<NutritionReadDto> findById(Long id) {
        return nutritionRepository.findById(id)
                .map(nutritionReadMapper::map);
    }

    public Optional<NutritionReadDto> findByUserIdAndDate(Long userId, LocalDate date) {
        return nutritionRepository.findByUserIdAndDate(userId, date)
                .map(nutritionReadMapper::map);
    }

    @Transactional
    public NutritionReadDto create(NutritionCreateEditDto nutritionDto) {
        return Optional.of(nutritionDto)
                .map(nutritionCreateEditMapper::map)
                .map(nutritionRepository::save)
                .map(nutritionReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<NutritionReadDto> update(Long id, NutritionCreateEditDto nutritionDto) {
        return nutritionRepository.findById(id)
                .map(entity -> nutritionCreateEditMapper.map(nutritionDto, entity))
                .map(nutritionRepository::saveAndFlush)
                .map(nutritionReadMapper::map);
    }

    @Transactional
    public boolean delete(Long id) {
        return nutritionRepository.findById(id)
                .map(entity -> {
                    nutritionRepository.delete(entity);
                    nutritionRepository.flush();
                    return true;
                }).orElse(false);
    }
}
