package com.example.quiz2.Controller;

import com.example.quiz2.Model.Student;
import com.example.quiz2.Service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudents(){
        return ResponseEntity.status(200).body(studentService.getStudents());
    }

    @PostMapping("/add")
    public ResponseEntity addStudents(@Valid @RequestBody Student student, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        studentService.addStudents(student);
        return ResponseEntity.status(200).body("Student added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudents(@PathVariable int id, @Valid @RequestBody Student student, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        studentService.updateStudents(id, student);
        return ResponseEntity.status(200).body("Student updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudents(@PathVariable int id, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        studentService.deleteStudents(id);
        return ResponseEntity.status(200).body("Student deleted");
    }

    @PutMapping("/search/{name}")
    public ResponseEntity searchStudents(@PathVariable String name){
        //if (errors.hasErrors())
          //  return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        return ResponseEntity.status(200).body(studentService.searchStudent(name).toString());
    }
}
