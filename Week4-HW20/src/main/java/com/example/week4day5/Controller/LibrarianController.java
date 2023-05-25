package com.example.week4day5.Controller;

import com.example.week4day5.ApiException.ApiException;
import com.example.week4day5.Model.Librarian;
import com.example.week4day5.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/librarian")
@RequiredArgsConstructor
public class LibrarianController {
    private final LibrarianService librarianService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(librarianService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addLibrarian(@Valid @RequestBody Librarian librarian){
        librarianService.addLibrarian(librarian);
        return ResponseEntity.status(200).body("Librarian added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateLibrarian(@PathVariable Integer id, @Valid @RequestBody Librarian librarian){
        librarianService.updateLibrarian(id, librarian);
        return ResponseEntity.status(200).body("Librarian updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLibrarian(@PathVariable Integer id){
        librarianService.deleteLibrarian(id);
        return ResponseEntity.status(200).body("Librarian deleted");
    }
    @GetMapping("/check/{name}/{password}")
    public ResponseEntity check(@PathVariable String name, @PathVariable String password){
        librarianService.checkUserAndPass(name,password);
        return ResponseEntity.status(200).body("username and password are correct");
    }
    @GetMapping("/get-by-email/{email}")
    public ResponseEntity getByEmail(@PathVariable String email){
        return ResponseEntity.status(200).body(librarianService.getByEmail(email));
    }
}
