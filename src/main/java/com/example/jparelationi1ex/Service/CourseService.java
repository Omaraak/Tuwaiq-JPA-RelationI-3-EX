package com.example.jparelationi1ex.Service;

import com.example.jparelationi1ex.Api.ApiException;
import com.example.jparelationi1ex.DTO.StudentDTO;
import com.example.jparelationi1ex.Model.Course;
import com.example.jparelationi1ex.Model.Student;
import com.example.jparelationi1ex.Model.Teacher;
import com.example.jparelationi1ex.Repository.CourseRepository;
import com.example.jparelationi1ex.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public void add(Course course) {
        courseRepository.save(course);
    }

    public void update(int id, Course course) throws ApiException {
        Course c = courseRepository.findCourseById(id);
        if (c == null){
            throw new ApiException("Course not found");
        }
        c.setName(course.getName());
        courseRepository.save(c);
    }

    public void delete(int id) throws ApiException {
        Course course = courseRepository.findCourseById(id);
        if (course == null){
            throw new ApiException("Course not found");
        }
        courseRepository.delete(course);
    }

    public Course findCourseById(int id) throws ApiException {
        Course course = courseRepository.findCourseById(id);
        if (course == null){
            throw new ApiException("Course not found");
        }
        return course;
    }

    public void assignCourse(int teacherID, int courseID) throws ApiException {
        Course course = courseRepository.findCourseById(courseID);
        if (course == null){
            throw new ApiException("Course not found");
        }
        Teacher teacher = teacherRepository.findTeacherById(teacherID);
        if (teacher == null){
            throw new ApiException("Teacher not found");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public String teacherName(int courseID) throws ApiException {
        Course course = courseRepository.findCourseById(courseID);
        Teacher teacher = teacherRepository.findTeacherById(course.getTeacher().getId());
        if (course == null || teacher == null){
            throw new ApiException("can't give teacher name");
        }
        return teacher.getName();
    }

    public List<StudentDTO> getStudents(int courseID) throws ApiException {
        Course course = courseRepository.findCourseById(courseID);
        if (course == null){
            throw new ApiException("Course not found");
        }
        List<StudentDTO> students = new ArrayList<>();
        for (Student s : course.getStudents()){
            StudentDTO studentDTO  = new StudentDTO(s.getId(),s.getName(), s.getAge(), s.getMajor());
            students.add(studentDTO);
        }
        return students;
    }
}
