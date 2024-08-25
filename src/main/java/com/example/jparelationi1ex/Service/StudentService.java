package com.example.jparelationi1ex.Service;

import com.example.jparelationi1ex.Api.ApiException;
import com.example.jparelationi1ex.Model.Course;
import com.example.jparelationi1ex.Model.Student;
import com.example.jparelationi1ex.Repository.CourseRepository;
import com.example.jparelationi1ex.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
//    private final StudentRepository courseRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void add(Student student) {
        studentRepository.save(student);
    }

    public void update(int id, Student student) throws ApiException {
        Student s = studentRepository.findStudentById(id);
        if (s == null){
            throw new ApiException("Student not found");
        }
        s.setName(student.getName());
        s.setAge(student.getAge());
        s.setMajor(student.getMajor());
        studentRepository.save(s);
    }

    public void delete(int id) throws ApiException {
        Student student = studentRepository.findStudentById(id);
        if (student == null){
            throw new ApiException("Student not found");
        }
        studentRepository.delete(student);
    }

    public void assignCourse (int studentID, int courseID) throws ApiException {
        Student student = studentRepository.findStudentById(studentID);
        Course course = courseRepository.findCourseById(courseID);
        if (student == null || course == null){
            throw new ApiException("Can't assign course");
        }
        student.getCourses().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }

    public void changeMajor(int id, String newMajor) throws ApiException {
        Student student = studentRepository.findStudentById(id);
        if (student == null){
            throw new ApiException("Student not found");
        }
        if (student.getMajor() != newMajor){
            student.setMajor(newMajor);
            for (Course course : student.getCourses()){
                course.getStudents().remove(student);
            }
            student.setCourses(null);
            studentRepository.save(student);
        }
    }

}
