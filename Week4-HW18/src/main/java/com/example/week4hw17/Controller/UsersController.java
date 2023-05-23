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
        if (UsersService.deleteUsers(id))
            return ResponseEntity.status(200).body("Users deleted");
        return ResponseEntity.status(400).body("id not found");
    }

    @GetMapping("/check/{username}/{password}")
    public ResponseEntity checkUesrs(@PathVariable String username,@PathVariable String password){
       // if (errors.hasErrors())
         //   return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        if (UsersService.checkUsernameAndPassword(username,password))
            return ResponseEntity.status(200).body("username and password are correct");
        else return ResponseEntity.status(400).body("username or password ar incorrect");
    }

    @GetMapping("/get-by-email/{email}")
    public ResponseEntity getByEmail(@PathVariable String email, Errors errors){
        //if (errors.hasErrors())
          //  return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        if (UsersService.getUserByEmail(email) != null)
            return ResponseEntity.status(200).body(UsersService.getUserByEmail(email).toString());
        else return ResponseEntity.status(400).body("user not found");
    }

    @GetMapping("/get-by-role/{role}")
    public ResponseEntity getAllByRole(@PathVariable String role, Errors errors){
       // if (errors.hasErrors())
         //   return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        if (!UsersService.getAllByRole(role).isEmpty())
            return ResponseEntity.status(200).body(UsersService.getAllByRole(role).toString());
        else return ResponseEntity.status(400).body("users not found");
    }

    @GetMapping("/get-by-age/{age}")
    public ResponseEntity getAllByAge(@PathVariable Integer age,Errors errors){
       // if (errors.hasErrors())
         //   return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        if (!UsersService.getAllByAge(age).isEmpty())
            return ResponseEntity.status(200).body(UsersService.getAllByAge(age).toString());
        else return ResponseEntity.status(400).body("users not found");
    }
}
