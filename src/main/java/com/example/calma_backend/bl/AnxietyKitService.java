package com.example.calma_backend.bl;


import com.example.calma_backend.dto.AnxietyKitDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AnxietyKitService {
    // Lista simulada de recursos del kit de control de ansiedad
    public List<AnxietyKitDTO> getAnxietyKit() {
        return Arrays.asList(
                new AnxietyKitDTO(
                        "Respiración Profunda",
                        "Un ejercicio de respiración 4-7-8 para calmarte.",
                        "audio",
                        "https://soundcloud.com/tupsicologa-cristiana/ejercicio-de-respiracio-n?si=a019b7e8dbfd4334b448c9b6d9714f23&utm_source=clipboard&utm_medium=text&utm_campaign=social_sharing"
                ),
                new AnxietyKitDTO(
                        "Meditación Guiada",
                        "Una meditación guiada para manejar la ansiedad.",
                        "audio",
                        "https://soundcloud.com/meditacionmaestro/meditacion-guiada-para-dormir?si=228533c37b2d4082b0515cd6e906663b&utm_source=clipboard&utm_medium=text&utm_campaign=social_sharing"
                ),
                new AnxietyKitDTO(
                        "Texto Motivacional",
                        "Recuerda: La ansiedad es temporal y tú tienes el control.",
                        "text",
                        null
                ),
                new AnxietyKitDTO(
                        "Imagen Relajante",
                        "Una imagen de la naturaleza para ayudarte a encontrar calma.",
                        "image",
                        "https://i.pinimg.com/736x/1e/77/03/1e77037e9729bdd47ddb20225ff54857.jpg"
                )
        );
    }
}
