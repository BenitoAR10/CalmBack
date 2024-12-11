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

    // Agregar a favoritos
    @PostMapping("/exercises/favorites")
    public String addToFavorites(@RequestParam String title) {
        boolean added = exerciseService.addToFavorites(title);
        return added ? "Exercise added to favorites." : "Exercise not found or already in favorites.";
    }

    // Quitar de favoritos
    @DeleteMapping("/exercises/favorites")
    public String removeFromFavorites(@RequestParam String title) {
        boolean removed = exerciseService.removeFromFavorites(title);
        return removed ? "Exercise removed from favorites." : "Exercise not found in favorites.";
    }

    // Obtener todos los favoritos
    @GetMapping("/exercises/favorites")
    public List<ExerciseDTO> getFavorites() {
        return exerciseService.getFavorites();
    }
}