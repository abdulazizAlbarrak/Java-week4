package com.example.quiz2.Controller;

import com.example.quiz2.Model.Teacher;
import com.example.quiz2.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@AllArgsConstructor
public class TeacherController {
    private final TeacherService TeacherService;

    @GetMapping("/get")
    public ResponseEntity getTeachers(){
        return ResponseEntity.status(200).body(TeacherService.getTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addTeachers(@Valid @RequestBody Teacher Teacher, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        TeacherService.addTeachers(Teacher);
        return ResponseEntity.status(200).body("Teacher added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeachers(@PathVariable int id, @Valid @RequestBody Teacher Teacher, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        TeacherService.updateTeachers(id, Teacher);
        return ResponseEntity.status(200).body("Teacher updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeachers(@PathVariable int id, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        TeacherService.deleteTeachers(id);
        return ResponseEntity.status(200).body("Teacher deleted");
    }

    @PutMapping("/search/{id}")
    public ResponseEntity searchTeachers(@PathVariable int id){
        //if (errors.hasErrors())
          //  return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        return ResponseEntity.status(200).body(TeacherService.searchTeacher(id).toString());
    }
}
