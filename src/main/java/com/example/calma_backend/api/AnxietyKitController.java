package com.example.calma_backend.api;


import com.example.calma_backend.bl.AnxietyKitService;
import com.example.calma_backend.dto.AnxietyKitDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AnxietyKitController {

    private final AnxietyKitService anxietyKitService;

    public AnxietyKitController(AnxietyKitService anxietyKitService) {
        this.anxietyKitService = anxietyKitService;
    }

    /**
     * Endpoint para obtener todos los recursos del kit de ansiedad.
     *
     * @return Una lista de AnxietyKitDTO.
     */
    @GetMapping("/anxiety-kit")
    public ResponseEntity<List<AnxietyKitDTO>> getAnxietyKit() {
        try {
            List<AnxietyKitDTO> resources = anxietyKitService.getAnxietyKit();
            if (resources.isEmpty()) {
                return ResponseEntity.noContent().build(); // 204 No Content
            }
            return ResponseEntity.ok(resources); // 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList()); // 500 Internal Server Error
        }
    }
}
