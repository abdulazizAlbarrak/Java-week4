package com.example.week3project.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {
    @NotNull(message = "ID should not be empty")
    @Min(value = 100,message = "ID should be 3 characters long")
    private int id;
    @NotNull(message = "Product ID should not be empty")
    @Min(value = 100,message = "ID should be 3 characters long")
    private int productId;
    @NotNull(message = "Merchant ID should not be empty")
    @Min(value = 100,message = "ID should be 3 characters long")
    private int merchantId;
    @NotNull(message = "Stock should not be empty")
    @Min(value = 0,message = "Stock should not be lss than zero")
    private int stock;////// has to be 10 at start!!!
}
