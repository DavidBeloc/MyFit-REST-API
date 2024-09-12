package com.davdev.controller;

import com.davdev.dto.WorkoutCreateEditDto;
import com.davdev.dto.WorkoutReadDto;
import com.davdev.service.WorkoutService;
import com.davdev.util.AppConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{userId}/workouts")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;

    @GetMapping("/{id}")
    public WorkoutReadDto findById(@PathVariable("id") Long id) {
        return workoutService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/date/{workoutDate}")
    public WorkoutReadDto findByUserIdAndDate(@PathVariable("userId") Long userId,
                                                @PathVariable("workoutDate") LocalDate date) {
        return workoutService.findByUserIdAndDate(userId, date)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<WorkoutReadDto> findAllByUserId(@PathVariable("userId") Long userId,
                                                @RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
                                                @RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
        return workoutService.findAllByUserId(userId, page, size);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorkoutReadDto create(@RequestBody WorkoutCreateEditDto workoutDto) {
        return workoutService.create(workoutDto);
    }

    @PutMapping("/{id}")
    public WorkoutReadDto update(@PathVariable("id") Long id,
                                   @RequestBody WorkoutCreateEditDto workoutDto) {
        return workoutService.update(id, workoutDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return workoutService.delete(id) ?
                ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
