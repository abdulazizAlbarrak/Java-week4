package com.example.week4hw17.Controller;

import com.example.week4hw17.Model.Users;
import com.example.week4hw17.Service.UsersService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UsersController {
    private final UsersService UsersService;

    @GetMapping("/get")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.status(200).body(UsersService.getUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUsers(@Valid @RequestBody Users Users, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        UsersService.addUsers(Users);
        return ResponseEntity.status(200).body("Users added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUsers(@PathVariable Integer id,@Valid @RequestBody Users Users, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(200).body(errors.getFieldError().getDefaultMessage());
        if (UsersService.updateUsers(id, Users))
            return ResponseEntity.status(200).body("Users updated");
        return ResponseEntity.status(400).body("id not found");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUsers(@PathVariable Integer id, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        if (UsersService.deleteCoffe(id))
            return ResponseEntity.status(200).body("Users deleted");
        return ResponseEntity.status(400).body("id not found");
    }
}
