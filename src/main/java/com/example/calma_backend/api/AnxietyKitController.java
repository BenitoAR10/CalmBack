package com.example.calma_backend.api;


import com.example.calma_backend.bl.AnxietyKitService;
import com.example.calma_backend.dto.AnxietyKitDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AnxietyKitController {

    private final AnxietyKitService anxietyKitService;

    public AnxietyKitController(AnxietyKitService anxietyKitService) {
        this.anxietyKitService = anxietyKitService;
    }

    // Endpoint para obtener los recursos del kit
    @GetMapping("/anxiety-kit")
    public List<AnxietyKitDTO> getAnxietyKit() {
        return anxietyKitService.getAnxietyKit();
    }
}
