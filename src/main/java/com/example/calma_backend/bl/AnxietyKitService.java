package com.example.calma_backend.bl;


import com.example.calma_backend.dao.AnxietyKitRepository;
import com.example.calma_backend.dto.AnxietyKitDTO;
import com.example.calma_backend.model.AnxietyKit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnxietyKitService {

    private final AnxietyKitRepository anxietyKitRepository;

    public AnxietyKitService(AnxietyKitRepository anxietyKitRepository) {
        this.anxietyKitRepository = anxietyKitRepository;
    }

    /**
     * Obtiene todos los recursos del kit de ansiedad desde la base de datos.
     *
     * @return Una lista de AnxietyKitDTO con los recursos del kit.
     */
    public List<AnxietyKitDTO> getAnxietyKit() {
        return anxietyKitRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Convierte una entidad AnxietyKit en un DTO.
     *
     * @param anxietyKit La entidad a convertir.
     * @return Un objeto AnxietyKitDTO.
     */
    private AnxietyKitDTO toDTO(AnxietyKit anxietyKit) {
        return new AnxietyKitDTO(
                anxietyKit.getTitle(),
                anxietyKit.getDescription(),
                anxietyKit.getType(),
                anxietyKit.getResourceUrl()
        );
    }
}
