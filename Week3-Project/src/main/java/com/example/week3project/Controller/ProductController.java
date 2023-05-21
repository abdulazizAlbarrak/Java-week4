package com.example.week3project.Controller;

import com.example.week3project.Model.Product;
import com.example.week3project.Service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService ProductService;

    @GetMapping("/get")
    public ResponseEntity getProduct(){
        return ResponseEntity.status(200).body(ProductService.getProducts());
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@Valid @RequestBody Product Product, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        ProductService.addProduct(Product);
        return ResponseEntity.status(200).body("Product added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable int id, @Valid @RequestBody Product Product, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        if (ProductService.updateProduct(id, Product))
            return ResponseEntity.status(200).body("Product updated");
        else return ResponseEntity.status(400).body("id not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id){
        if (ProductService.deleteProduct(id))
            return ResponseEntity.status(200).body("Product deleted");
        else return ResponseEntity.status(400).body("id not found");
    }

    public ProductService getProducts(){
        return ProductService;
    }
}
