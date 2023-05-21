package com.example.week3project.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    public static final String Admin = "Admin";
    public static final String Customer = "Customer";

    @NotNull(message = "ID should not be empty")
    @Min(value = 100,message = "ID should be 3 characters long")
    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 5,message = "Name should be 5 characters long")
    private String username;
    @NotEmpty(message = "Password should not be empty")
    @Size(min = 5,message = "Password should be 5 characters long")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$",message = "must have at least one letter and one digit")
    private String password;
    @NotBlank(message = "must not be empty")
    @Email(message = "must be a vaild email")
    private String email;
    @NotEmpty(message = "role should not be empty")
    @Pattern(regexp = "^(" + Admin + "|" + Customer + ")",message = "only Admin and Customer")
    private String role;
    @NotNull(message = "balance should not be empty")
    @Min(value = 0)
    private double balance;
}
