package com.example.calma_backend.bl;

import com.example.calma_backend.dao.ExerciseRepository;
import com.example.calma_backend.dto.ExerciseDTO;
import com.example.calma_backend.model.Exercises;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    // Obtener todos los ejercicios
    public List<ExerciseDTO> getAllExercises() {
        return exerciseRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Obtener ejercicios por categoría
    public List<ExerciseDTO> getExercisesByCategory(String category) {
        return exerciseRepository.findAll().stream()
                .filter(e -> e.getCategory().equalsIgnoreCase(category))
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Agregar un ejercicio a favoritos
    public boolean addToFavorites(Long id) {
        Exercises exercise = exerciseRepository.findById(id).orElse(null);

        if (exercise != null && !exercise.isFavorite()) {
            exercise.setFavorite(true);
            exerciseRepository.save(exercise);
            return true;
        }
        return false;
    }

    // Quitar un ejercicio de favoritos
    public boolean removeFromFavorites(Long id) {
        Exercises exercise = exerciseRepository.findById(id).orElse(null);

        if (exercise != null && exercise.isFavorite()) {
            exercise.setFavorite(false);
            exerciseRepository.save(exercise);
            return true;
        }
        return false;
    }

    // Obtener todos los ejercicios favoritos
    public List<ExerciseDTO> getFavorites() {
        return exerciseRepository.findAll().stream()
                .filter(Exercises::isFavorite)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ExerciseDTO toDTO(Exercises exercise) {
        return new ExerciseDTO(
                exercise.getTitle(),
                exercise.getDescription(),
                exercise.getCategory(),
                exercise.getAudioUrl(),
                exercise.getImageUrl()
        );
    }

}