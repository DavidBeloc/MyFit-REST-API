package com.davdev.http.rest;

import com.davdev.dto.ExerciseCreateEditDto;
import com.davdev.dto.ExerciseReadDto;
import com.davdev.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{userId}/workout/{workoutId}/exercise")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    @GetMapping("/{id}")
    public ExerciseReadDto findById(@PathVariable("id") Long id) {
        return exerciseService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    public List<ExerciseReadDto> findAllByWorkoutId(@PathVariable("workoutId") Long workoutId) {
        return exerciseService.findAllByWorkoutId(workoutId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExerciseReadDto create(@RequestBody ExerciseCreateEditDto exerciseDto) {
        return exerciseService.create(exerciseDto);
    }

    @PutMapping("/{id}")
    public ExerciseReadDto update(@PathVariable("id") Long id,
                                 @RequestBody ExerciseCreateEditDto exerciseDto) {
        return exerciseService.update(id, exerciseDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return exerciseService.delete(id) ?
                ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
