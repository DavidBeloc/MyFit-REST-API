package com.davdev.service;

import com.davdev.database.repository.ExerciseRepository;
import com.davdev.dto.ExerciseCreateEditDto;
import com.davdev.dto.ExerciseReadDto;
import com.davdev.mapper.ExerciseCreatEditMapper;
import com.davdev.mapper.ExerciseReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseReadMapper exerciseReadMapper;
    private final ExerciseCreatEditMapper exerciseCreatEditMapper;

    public Optional<ExerciseReadDto> findById(Long id) {
        return exerciseRepository.findById(id)
                .map(exerciseReadMapper::map);
    }

    public List<ExerciseReadDto> findAllByWorkoutId(Long workoutId) {
        return exerciseRepository.findAllByWorkoutId(workoutId).stream()
                .map(exerciseReadMapper::map).toList();
    }

    @Transactional
    public ExerciseReadDto create(ExerciseCreateEditDto exerciseCreateEditDto) {
        return Optional.of(exerciseCreateEditDto)
                .map(exerciseCreatEditMapper::map)
                .map(exerciseRepository::save)
                .map(exerciseReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<ExerciseReadDto> update(Long id, ExerciseCreateEditDto exerciseDto) {
        return exerciseRepository.findById(id)
                .map(entity -> exerciseCreatEditMapper.map(exerciseDto, entity))
                .map(exerciseRepository::saveAndFlush)
                .map(exerciseReadMapper::map);
    }

    @Transactional
    public boolean delete(Long id) {
        return exerciseRepository.findById(id)
                .map(entity -> {
                    exerciseRepository.delete(entity);
                    exerciseRepository.flush();
                    return true;
                }).orElse(false);
    }
}
