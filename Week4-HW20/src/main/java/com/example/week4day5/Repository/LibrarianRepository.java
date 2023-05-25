package com.example.week4day5.Repository;

import com.example.week4day5.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian,Integer> {
    Librarian getLibrarianById(Integer id);
    Librarian getLibrarianByEmail(String email);
    Librarian getLibrarianByName(String name);
}
