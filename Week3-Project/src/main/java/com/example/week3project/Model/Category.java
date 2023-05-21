package com.example.week3project.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
public class Category {
    @NotNull(message = "ID should not be empty")
    @Min(value = 100,message = "ID should be 3 characters long")
    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 3,message = "Name should be 3 characters long")
    private String name;
}
