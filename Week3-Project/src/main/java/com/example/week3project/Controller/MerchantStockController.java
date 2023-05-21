package com.example.week3project.Controller;

import com.example.week3project.Model.MerchantStock;
import com.example.week3project.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/merchant-stock")
@AllArgsConstructor
public class MerchantStockController {
    private final MerchantStockService MerchantStockService;

    @GetMapping("/get")
    public ResponseEntity getMerchantStock(){
        return ResponseEntity.status(200).body(MerchantStockService.getMerchantStocks());
    }

    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@Valid @RequestBody MerchantStock MerchantStock, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        if (MerchantStock.getStock() > 10) {
            MerchantStockService.addMerchantStock(MerchantStock);
            return ResponseEntity.status(200).body("MerchantStock added");
        }else return ResponseEntity.status(400).body("Stock has to be more than 10");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchantStock(@PathVariable int id, @Valid @RequestBody MerchantStock MerchantStock, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        if (MerchantStockService.updateMerchantStock(id, MerchantStock))
            return ResponseEntity.status(200).body("MerchantStock updated");
        else return ResponseEntity.status(400).body("id not found");
    }

    @PutMapping("/add-product/{productid}/{merchantid}/{stock}")
    public ResponseEntity addProduct(@PathVariable int productid,@PathVariable int merchantid,@PathVariable int stock){
        if (MerchantStockService.addStock(merchantid,productid,stock))
            return ResponseEntity.status(200).body("Product added");
        else return ResponseEntity.status(400).body("id not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable int id){
        if (MerchantStockService.deleteMerchantStock(id))
            return ResponseEntity.status(200).body("MerchantStock deleted");
        else return ResponseEntity.status(400).body("id not found");
    }

    public MerchantStockService getMerchantStockService(){
        return MerchantStockService;
    }
}
