package com.example.week4day5.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(25) not null unique")
    private String name;
    @NotEmpty
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,}$")
    @Column(columnDefinition = "varchar(40) not null")
    private String password;
    @Email
    @NotEmpty
    @Column(columnDefinition = "varchar(50) not null unique")
    private String email;
}
