package com.example.calma_backend.api;


import com.example.calma_backend.bl.ExerciseService;
import com.example.calma_backend.dto.ExerciseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    // Obtener todos los ejercicios
    @GetMapping("/exercises")
    public List<ExerciseDTO> getAllExercises() {
        return exerciseService.getAllExercises();
    }

    // Obtener ejercicios por categoría
    @GetMapping("/exercises/category")
    public List<ExerciseDTO> getExercisesByCategory(@RequestParam String category) {
        return exerciseService.getExercisesByCategory(category);
    }

    // Agregar un ejercicio a favoritos por ID
    @PostMapping("/exercises/{id}/favorites")
    public String addToFavorites(@PathVariable Long id) {
        boolean added = exerciseService.addToFavorites(id);
        return added ? "Exercise added to favorites." : "Exercise not found or already in favorites.";
    }

    // Quitar un ejercicio de favoritos por ID
    @DeleteMapping("/exercises/{id}/favorites")
    public String removeFromFavorites(@PathVariable Long id) {
        boolean removed = exerciseService.removeFromFavorites(id);
        return removed ? "Exercise removed from favorites." : "Exercise not found in favorites.";
    }

    // Obtener todos los ejercicios favoritos
    @GetMapping("/exercises/favorites")
    public List<ExerciseDTO> getFavorites() {
        return exerciseService.getFavorites();
    }
}
