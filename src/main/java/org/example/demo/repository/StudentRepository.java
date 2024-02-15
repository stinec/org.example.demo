package org.example.demo.repository;

import org.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByEmail(String email);
    List<Student> findByNameContaining(String name);
}
