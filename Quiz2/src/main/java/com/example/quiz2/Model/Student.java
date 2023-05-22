package com.example.quiz2.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotNull(message = "ID should not be empty")
    @Min(value = 0,message = "ID cant be negative")
    private int id;
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotNull(message = "Age should not be empty")
    @Min(value = 15,message = "Age should not be bellow 15")
    private int age;
    @NotEmpty(message = "Major should not be empty")
    private String major;
}
