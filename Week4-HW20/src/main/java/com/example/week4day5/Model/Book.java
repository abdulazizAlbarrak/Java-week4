package com.example.week4day5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Transient
    @JsonIgnore
    private final String cat1="Academic";
    @Transient
    @JsonIgnore
    private final String cat2="Mystery";
    @Transient
    @JsonIgnore
    private final String cat3="Novel";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(25) not null unique")
    private String title;
    @NotEmpty
    @Column(columnDefinition = "varchar(15) not null")
    private String author;
    @NotEmpty
    @Pattern(regexp = "^("+cat1+"|"+cat2+"|"+cat3+")")
    @Column(columnDefinition = "varchar(8) not null check(category='Academic' or category='Mystery' or category='Novel')")
    private String category;
    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer isbn;
    @NotNull
    @Min(value = 50,message = "pages minimum is 50 pages")
    @Column(columnDefinition = "int not null")
    private Integer numberOfPages;
}
