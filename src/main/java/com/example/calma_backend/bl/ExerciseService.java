package com.example.calma_backend.bl;

import com.example.calma_backend.dto.ExerciseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ExerciseService {
    // Lista simulada de ejercicios
    private final List<ExerciseDTO> exercises = new ArrayList<>(Arrays.asList(
            new ExerciseDTO(
                    "Relajación con el Río",
                    "Disfruta del sonido de un río suave para relajarte.",
                    "Ansiedad",
                    "https://soundcloud.com/musicarelajanteofficial/sets/top-50-musica-relajante-para?si=84b0d36a25cb4752ba3fbf92521da05a&utm_source=clipboard&utm_medium=text&utm_campaign=social_sharing"
            ),
            new ExerciseDTO(
                    "Meditación con Lluvia",
                    "Llueve suavemente mientras encuentras tu paz interior.",
                    "Estrés",
                    "https://soundcloud.com/musicarelajanteofficial/sets/top-50-musica-relajante-para?si=84b0d36a25cb4752ba3fbf92521da05a&utm_source=clipboard&utm_medium=text&utm_campaign=social_sharing"
            ),
            new ExerciseDTO(
                    "Melodía Calmante",
                    "Piano instrumental para una relajación profunda.",
                    "Ansiedad",
                    "https://soundcloud.com/musicarelajanteofficial/sets/top-50-musica-relajante-para?si=84b0d36a25cb4752ba3fbf92521da05a&utm_source=clipboard&utm_medium=text&utm_campaign=social_sharing"
            )
    ));

    // Lista simulada para favoritos
    private final List<ExerciseDTO> favoriteExercises = new ArrayList<>();

    // Obtener todos los ejercicios
    public List<ExerciseDTO> getAllExercises() {
        return exercises;
    }

    // Obtener ejercicios por categoría
    public List<ExerciseDTO> getExercisesByCategory(String category) {
        return exercises.stream()
                .filter(e -> e.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    // Agregar un ejercicio a favoritos
    public boolean addToFavorites(String title) {
        ExerciseDTO exercise = exercises.stream()
                .filter(e -> e.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);

        if (exercise != null && !favoriteExercises.contains(exercise)) {
            favoriteExercises.add(exercise);
            return true;
        }
        return false;
    }

    // Quitar un ejercicio de favoritos
    public boolean removeFromFavorites(String title) {
        return favoriteExercises.removeIf(e -> e.getTitle().equalsIgnoreCase(title));
    }

    // Obtener todos los favoritos
    public List<ExerciseDTO> getFavorites() {
        return favoriteExercises;
    }

}
