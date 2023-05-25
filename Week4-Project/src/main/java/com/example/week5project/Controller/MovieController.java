package com.example.week5project.Controller;

import com.example.week5project.Model.Movie;
import com.example.week5project.Service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(movieService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody Movie movie){
        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("Movie added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@Valid @RequestBody Movie movie){
        movieService.updateMovie(id, movie);
        return ResponseEntity.status(200).body("Movie updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Movie deleted");
    }
    @GetMapping("/search/{name}")
    public ResponseEntity search(@PathVariable String name){
        return ResponseEntity.status(200).body(movieService.getMovieByTitle(name));
    }
    @GetMapping("/get-duration/{name}")
    public ResponseEntity getDuration(@PathVariable String name){
        return ResponseEntity.status(200).body(movieService.getDuration(name));
    }
    @GetMapping("/get-director/{name}")
    public ResponseEntity getDirector(@PathVariable String name){
        return ResponseEntity.status(200).body(movieService.getDirectorName(name));
    }
    @GetMapping("/get-movies-by-director/{name}")
    public ResponseEntity getMoviesByDirector(@PathVariable String name){
        return ResponseEntity.status(200).body(movieService.getMoviesByDirector(name));
    }
    @GetMapping("/get-rate/{name}")
    public ResponseEntity getRateOfMovie(@PathVariable String name){
        return ResponseEntity.status(200).body(movieService.getRate(name));
    }
    @GetMapping("/get-above-rate/{rate}")
    public ResponseEntity getMoviesAboveRate(@PathVariable Integer rate){
        return ResponseEntity.status(200).body(movieService.getMoviesByRate(rate));
    }
    @GetMapping("/get-by-genre/{genre}")
    public ResponseEntity getMoviesByGenre(@PathVariable String genre){
        return ResponseEntity.status(200).body(movieService.getMoviesByGenre(genre));
    }
}
