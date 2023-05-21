package com.example.week3project.Controller;

import com.example.week3project.Model.Category;
import com.example.week3project.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity getCategory(){
        return ResponseEntity.status(200).body(categoryService.getCategories());
    }

    @PostMapping("/add")
    public ResponseEntity addCategory(@Valid @RequestBody Category category, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body("Category added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable int id, @Valid @RequestBody Category category, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        if (categoryService.updateCategory(id, category))
            return ResponseEntity.status(200).body("Category updated");
        else return ResponseEntity.status(400).body("id not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable int id){
        if (categoryService.deleteCategory(id))
            return ResponseEntity.status(200).body("Category deleted");
        else return ResponseEntity.status(400).body("id not found");
    }
}
