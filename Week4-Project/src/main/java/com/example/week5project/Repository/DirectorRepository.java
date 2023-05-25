package com.example.week5project.Repository;

import com.example.week5project.Model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Integer> {
    List<Director> getAllById(Integer id);
    Director getDirectorById(Integer id);
    Director getDirectorByName(String name);
}
