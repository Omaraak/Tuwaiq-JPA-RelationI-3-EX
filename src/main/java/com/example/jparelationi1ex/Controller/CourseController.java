package com.example.jparelationi1ex.Controller;

import com.example.jparelationi1ex.Api.ApiException;
import com.example.jparelationi1ex.DTO.StudentDTO;
import com.example.jparelationi1ex.Model.Course;
import com.example.jparelationi1ex.Model.Student;
import com.example.jparelationi1ex.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.status(200).body(courseService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody Course course) {
        courseService.add(course);
        return ResponseEntity.status(200).body("Course added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id, @Valid @RequestBody Course course) throws ApiException {
        courseService.update(id, course);
        return ResponseEntity.status(200).body("Course updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id) throws ApiException {
        courseService.delete(id);
        return ResponseEntity.status(200).body("Course deleted successfully");
    }
    @PutMapping("/assignCourse/{t_id}/{c_id}")
    public ResponseEntity findCourseById(@PathVariable int t_id, @PathVariable int c_id) throws ApiException {
        courseService.assignCourse(t_id, c_id);
        return ResponseEntity.status(200).body("Assign");
    }

    @GetMapping("/teacherName/{courseID}")
    public String getTeacherName(@PathVariable int courseID) throws ApiException {
        return courseService.teacherName(courseID);
    }

    @GetMapping("/getStudents/{courseID}")
    public ResponseEntity<List<StudentDTO>> getStudents(@PathVariable int courseID) throws ApiException {
        return ResponseEntity.status(200).body(courseService.getStudents(courseID));
    }
}
