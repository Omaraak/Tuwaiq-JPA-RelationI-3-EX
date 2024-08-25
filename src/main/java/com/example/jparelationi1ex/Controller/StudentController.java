package com.example.jparelationi1ex.Controller;

import com.example.jparelationi1ex.Api.ApiException;
import com.example.jparelationi1ex.Model.Student;
import com.example.jparelationi1ex.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.status(200).body(studentService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody Student student) {
        studentService.add(student);
        return ResponseEntity.status(200).body("Student added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id, @Valid @RequestBody Student student) throws ApiException {
        studentService.update(id, student);
        return ResponseEntity.status(200).body("Student updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id) throws ApiException {
        studentService.delete(id);
        return ResponseEntity.status(200).body("Student deleted successfully");
    }
    @PutMapping("/assignCourse/{studentID}/{courseID}")
    public ResponseEntity<String> findStudentById(@PathVariable int studentID, @PathVariable int courseID) throws ApiException {
        studentService.assignCourse(studentID, courseID);
        return ResponseEntity.status(200).body("Course assigned successfully");
    }

    @PutMapping("/changeMajor/{id}/{newMajor}")
    public ResponseEntity<String> changeMajor(@PathVariable int id, @PathVariable String newMajor) throws ApiException {
        studentService.changeMajor(id,newMajor);
        return ResponseEntity.status(200).body("Major changed successfully");
    }
}
