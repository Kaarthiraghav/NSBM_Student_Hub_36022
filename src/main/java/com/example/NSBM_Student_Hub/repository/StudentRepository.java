package com.example.NSBM_Student_Hub.repository;

import com.example.NSBM_Student_Hub.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    // Find student by email
    Optional<Student> findByEmail(String email);
    
    // Find students by batch with pagination
    Page<Student> findByBatch(String batch, Pageable pageable);
    
    // Find students by name with pagination (case-insensitive)
    Page<Student> findByNameContainingIgnoreCase(String name, Pageable pageable);
    
    // Check if student exists by email
    boolean existsByEmail(String email);
}
