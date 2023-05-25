package com.example.week5project.Model;

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
public class Movie {
    @Transient
    @JsonIgnore
    private final String gen1="Drama";
    @Transient
    @JsonIgnore
    private final String gen2="Action";
    @Transient
    @JsonIgnore
    private final String gen3="Comedy";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty
    @Size(min = 3)
    @Column(columnDefinition = "varchar(50) not null")
    private String name;
    @NotEmpty
    @Pattern(regexp = "^("+gen1+"|"+gen2+"|"+gen3+")")
    @Column(columnDefinition = "varchar(50) not null check(genre='Drama' or genre='Action' or genre='Comedy')")
    private String genre;
    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    @Column(columnDefinition = "int not null")
    private Integer rating;
    @NotNull
    @Min(60)
    @Column(columnDefinition = "int not null")
    private Integer duration;
    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer directorId;

}
