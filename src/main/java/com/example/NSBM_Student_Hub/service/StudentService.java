package com.example.NSBM_Student_Hub.service;

import com.example.NSBM_Student_Hub.model.Student;
import com.example.NSBM_Student_Hub.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    // Create a new student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    
    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    // Get all students with pagination and sorting
    public Page<Student> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }
    
    // Get student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }
    
    // Get student by email
    public Optional<Student> getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }
    
    // Get students by batch
    public Page<Student> getStudentsByBatch(String batch, Pageable pageable) {
        return studentRepository.findByBatch(batch, pageable);
    }
    
    // Search students by name
    public Page<Student> searchByName(String name, Pageable pageable) {
        return studentRepository.findByNameContainingIgnoreCase(name, pageable);
    }
    
    // Update student
    public Optional<Student> updateStudent(Long id, Student studentDetails) {
        return studentRepository.findById(id).map(student -> {
            if (studentDetails.getName() != null) {
                student.setName(studentDetails.getName());
            }
            if (studentDetails.getEmail() != null) {
                student.setEmail(studentDetails.getEmail());
            }
            if (studentDetails.getBatch() != null) {
                student.setBatch(studentDetails.getBatch());
            }
            if (studentDetails.getGpa() != null) {
                student.setGpa(studentDetails.getGpa());
            }
            return studentRepository.save(student);
        });
    }
    
    // Delete student
    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    // Check if student exists by email
    public boolean studentExistsByEmail(String email) {
        return studentRepository.existsByEmail(email);
    }
}
