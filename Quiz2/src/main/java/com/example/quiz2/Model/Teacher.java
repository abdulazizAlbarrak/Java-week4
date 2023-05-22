package com.example.quiz2.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotNull(message = "ID should not be empty")
    @Min(value = 0,message = "ID should not be negative")
    private int id;
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotNull(message = "Salary should not be empty")
    @Min(value = 2000,message = "Salary should not be bellow 2000")
    private double salary;
}
