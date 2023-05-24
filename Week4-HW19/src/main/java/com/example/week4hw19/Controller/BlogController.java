package com.example.week4hw19.Controller;

import com.example.week4hw19.Model.Blog;
import com.example.week4hw19.Service.BlogService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(blogService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody Blog blog){
        blogService.addBlog(blog);
        return ResponseEntity.status(200).body("blog added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id,@Valid @RequestBody Blog blog){
        blogService.updateBlog(id,blog);
        return ResponseEntity.status(200).body("blog updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        blogService.deleteBlog(id);
        return ResponseEntity.status(200).body("blog deleted");
    }
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity getById(@PathVariable int id){
        return ResponseEntity.status(200).body(blogService.getBlogById(id));
    }
    @GetMapping("/get-by-title/{title}")
    public ResponseEntity getByTitle(@PathVariable String title){
        return ResponseEntity.status(200).body(blogService.getBlogByTitle(title));
    }
    @GetMapping("/get-by-category/{category}")
    public ResponseEntity getByCategory(@PathVariable String category){
        return ResponseEntity.status(200).body(blogService.getBlogByCategory(category));
    }
    @PutMapping("/change-status/{id}")
    public ResponseEntity changeStatus(@PathVariable int id){
        blogService.changeStatus(id);
        return ResponseEntity.status(200).body("Published status changed to true");
    }
}
