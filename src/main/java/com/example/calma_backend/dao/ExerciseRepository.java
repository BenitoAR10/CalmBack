package com.example.calma_backend.dao;




import com.example.calma_backend.model.Exercises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ExerciseRepository extends JpaRepository<Exercises, Long> {
    List<Exercises> findByCategory(String category);
}
