package com.example.week4hw17.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(4) not null")
    private String name;
    @NotEmpty
    @Column(columnDefinition = "varchar(4) not null unique")
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    @Email
    @Column(columnDefinition = "varchar(299) not null unique")
    private String email;
    @NotEmpty
    @Column(columnDefinition = "varchar(4) not null unique check( role='admin' or role = 'user' )")
    private String role;
    @NotNull
    @Column(columnDefinition = "int not null unique")
    private Integer age;
}
