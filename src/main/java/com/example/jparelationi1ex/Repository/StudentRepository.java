package com.example.jparelationi1ex.Repository;

import com.example.jparelationi1ex.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findStudentById(int id);
}
