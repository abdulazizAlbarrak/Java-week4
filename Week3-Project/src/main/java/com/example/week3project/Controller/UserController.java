package com.example.week3project.Controller;

import com.example.week3project.Model.User;
import com.example.week3project.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private final UserService UserService;
    private ProductController productController;
    private MerchantController merchantController;
    private MerchantStockController merchantStockController;
    @GetMapping("/get")
    public ResponseEntity getUser(){
        return ResponseEntity.status(200).body(UserService.getUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User User, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        UserService.addUser(User);
        return ResponseEntity.status(200).body("User added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable int id, @Valid @RequestBody User User, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        if (UserService.updateUser(id, User))
            return ResponseEntity.status(200).body("User updated");
        else return ResponseEntity.status(400).body("id not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable int id){
        if (UserService.deleteUser(id))
            return ResponseEntity.status(200).body("User deleted");
        else return ResponseEntity.status(400).body("id not found");
    }

    @PutMapping("/buy-product/{userid}/{productid}/{merchantid}")
    public ResponseEntity buyProduct(@PathVariable int userid,@PathVariable int productid,@PathVariable int merchantid){
        if (UserService.checkUserId(userid) && productController.getProducts().checkProductId(productid) && merchantController.getMerchantService().checkMerchantId(merchantid)){
            if (UserService.getUsers().get(userid).getBalance()-productController.getProducts().getPrice(productid)<0)
                return ResponseEntity.status(400).body("user balance is not enough");
            if (merchantStockController.getMerchantStockService().checkStock(merchantid)){
                UserService.reduceBalance(userid,productController.getProducts().getPrice(productid));
                return ResponseEntity.status(200).body("Product bought");
            }else ResponseEntity.status(400).body("merchant does not have product in stock");
        }return ResponseEntity.status(400).body("id not found");
    }
}
