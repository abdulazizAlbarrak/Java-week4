package com.example.week5project.Repository;

import com.example.week5project.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    List<Movie> getAllById(Integer id);
    Movie getMovieByName(String name);
    List<Movie> getMoviesByDirectorId(Integer id);
    List<Movie> getMoviesByRatingGreaterThan(Integer rate);
    List<Movie> getMoviesByGenre(String genre);
    Movie getMovieById(Integer id);

}
