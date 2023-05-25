package com.example.week5project.Controller;

import com.example.week5project.Model.Director;
import com.example.week5project.Service.DirectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/director")
@RequiredArgsConstructor
public class DirectorController {
    private final DirectorService directorService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(directorService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody Director director){
        directorService.addDirector(director);
        return ResponseEntity.status(200).body("Director added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@Valid @RequestBody Director director){
        directorService.updateDirector(id, director);
        return ResponseEntity.status(200).body("Director updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        directorService.deleteDirector(id);
        return ResponseEntity.status(200).body("Director deleted");
    }
}
