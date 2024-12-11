package com.example.calma_backend.dao;

import com.example.calma_backend.model.AnxietyKit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnxietyKitRepository extends JpaRepository<AnxietyKit, Long> {
    List<AnxietyKit> findByType(String type); // Filtrar por tipo (audio, text, image)
}