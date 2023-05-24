package com.example.week4hw19.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Blog {
    @Transient
    @JsonIgnore
    private final String cat1 = "health";
    @Transient
    @JsonIgnore
    private final String cat2 = "education";
    @Transient
    @JsonIgnore
    private final String cat3 = "programming";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(30) not null")
    private String title;
    @NotEmpty
    @Column(columnDefinition = "varchar(12) not null check(category='health' or category='education' or category='programming')")
    @Pattern(regexp = "^("+cat1+"|"+cat2+"|"+cat3+")",message = "category can only be (1)health (2)education (3)programming")
    private String category;
    @NotEmpty
    @Size(min = 0,max = 300,message = "300 max letters")
    @Column(columnDefinition = "varchar(300) not null")
    private String body;
    @Column(columnDefinition = "boolean default false")
    private boolean isPublished;
}
