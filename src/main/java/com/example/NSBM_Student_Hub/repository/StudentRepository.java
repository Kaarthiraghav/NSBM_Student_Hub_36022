package com.example.NSBM_Student_Hub.repository;

import com.example.NSBM_Student_Hub.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    // Find student by email
    Optional<Student> findByEmail(String email);
    
    // Find students by batch
    List<Student> findByBatch(String batch);
    
    // Find students by name (case-insensitive)
    List<Student> findByNameContainingIgnoreCase(String name);
    
    // Check if student exists by email
    boolean existsByEmail(String email);
}
