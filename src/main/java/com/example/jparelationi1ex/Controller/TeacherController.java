package com.example.jparelationi1ex.Controller;

import com.example.jparelationi1ex.Api.ApiException;
import com.example.jparelationi1ex.Model.Teacher;
import com.example.jparelationi1ex.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Teacher>> getAll() {
        return ResponseEntity.status(200).body(teacherService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody Teacher teacher) {
        teacherService.add(teacher);
        return ResponseEntity.status(200).body("Teacher added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id, @Valid @RequestBody Teacher teacher) throws ApiException {
        teacherService.update(id, teacher);
        return ResponseEntity.status(200).body("Teacher updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id) throws ApiException {
        teacherService.delete(id);
        return ResponseEntity.status(200).body("Teacher deleted successfully");
    }
    @GetMapping("/findTeacherById/{id}")
    public ResponseEntity<Teacher> findTeacherById(@PathVariable int id) throws ApiException {
        return ResponseEntity.status(200).body(teacherService.findTeacherById(id));
    }
}
