package com.example.jparelationi1ex.Service;

import com.example.jparelationi1ex.Api.ApiException;
import com.example.jparelationi1ex.Model.Teacher;
import com.example.jparelationi1ex.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public void add(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void update(int id, Teacher teacher) throws ApiException {
        Teacher t = teacherRepository.findTeacherById(id);
        if (t == null){
            throw new ApiException("Teacher not found");
        }
        t.setName(teacher.getName());
        teacherRepository.save(t);
    }

    public void delete(int id) throws ApiException {
        Teacher t = teacherRepository.findTeacherById(id);
        if (t == null){
            throw new ApiException("Teacher not found");
        }
        teacherRepository.delete(t);
    }

    public Teacher findTeacherById(int id) throws ApiException {
        Teacher t = teacherRepository.findTeacherById(id);
        if (t == null){
            throw new ApiException("Teacher not found");
        }
        return t;
    }
}
