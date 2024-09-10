package com.davdev.service;

import com.davdev.database.repository.WorkoutRepository;
import com.davdev.dto.WorkoutCreateEditDto;
import com.davdev.dto.WorkoutReadDto;
import com.davdev.mapper.WorkoutCreatEditMapper;
import com.davdev.mapper.WorkoutReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final WorkoutReadMapper workoutReadMapper;
    private final WorkoutCreatEditMapper workoutCreatEditMapper;

    public Optional<WorkoutReadDto> findById(Long id) {
        return workoutRepository.findById(id)
                .map(workoutReadMapper::map);
    }

    public List<WorkoutReadDto> findAllByUserId(Long userId, Pageable pageable) {
        return workoutRepository.findAllByUserIdOrderByDateDesc(userId, pageable).stream()
                .map(workoutReadMapper::map)
                .toList();
    }

    public Optional<WorkoutReadDto> findByUserIdAndDate(Long id, LocalDate date) {
        return workoutRepository.findByUserIdAndDate(id, date)
                .map(workoutReadMapper::map);
    }

    @Transactional
    public WorkoutReadDto create(WorkoutCreateEditDto workoutDto) {
        return Optional.of(workoutDto)
                .map(workoutCreatEditMapper::map)
                .map(workoutRepository::save)
                .map(workoutReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<WorkoutReadDto> update(Long id, WorkoutCreateEditDto workoutDto) {
        return workoutRepository.findById(id)
                .map(entity -> workoutCreatEditMapper.map(workoutDto, entity))
                .map(workoutRepository::saveAndFlush)
                .map(workoutReadMapper::map);
    }

    @Transactional
    public boolean delete(Long id) {
        return workoutRepository.findById(id)
                .map(entity -> {
                    workoutRepository.delete(entity);
                    workoutRepository.flush();
                    return true;
                }).orElse(false);
    }
}
