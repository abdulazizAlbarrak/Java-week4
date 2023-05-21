package com.example.week3project.Controller;

import com.example.week3project.Model.Merchant;
import com.example.week3project.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/merchant")
@AllArgsConstructor
public class MerchantController {
    private final MerchantService MerchantService;

    @GetMapping("/get")
    public ResponseEntity getMerchant(){
        return ResponseEntity.status(200).body(MerchantService.getMerchants());
    }

    @PostMapping("/add")
    public ResponseEntity addMerchant(@Valid @RequestBody Merchant Merchant, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        MerchantService.addMerchant(Merchant);
        return ResponseEntity.status(200).body("Merchant added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@PathVariable int id, @Valid @RequestBody Merchant Merchant, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        if (MerchantService.updateMerchant(id, Merchant))
            return ResponseEntity.status(200).body("Merchant updated");
        else return ResponseEntity.status(400).body("id not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable int id){
        if (MerchantService.deleteMerchant(id))
            return ResponseEntity.status(200).body("Merchant deleted");
        else return ResponseEntity.status(400).body("id not found");
    }

    public MerchantService getMerchantService(){
        return MerchantService;
    }
}
