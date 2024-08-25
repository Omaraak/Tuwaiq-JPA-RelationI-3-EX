package com.example.jparelationi1ex.Repository;

import com.example.jparelationi1ex.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findTeacherById(int id);
}
