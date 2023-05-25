package com.example.week5project.Service;

import com.example.week5project.ApiException.ApiException;
import com.example.week5project.Model.Movie;
import com.example.week5project.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final DirectorService directorService;

    //Start of CRUD
    public List<Movie> getAll(){
        return movieRepository.findAll();
    }
    public void addMovie(Movie movie){
        if (directorService.getDirectorById(movie.getDirectorId()) == null){
            throw new ApiException("Director id was not found");
        }
        movieRepository.save(movie);
    }
    public void updateMovie(Integer id, Movie movie){
        if (directorService.getDirectorById(movie.getDirectorId()) == null){
            throw new ApiException("Director id was not found");
        }
        Movie old=movieRepository.getMovieById(id);
        old.setName(movie.getName());
        old.setDuration(movie.getDuration());
        old.setRating(movie.getRating());
        old.setGenre(movie.getGenre());
        old.setDirectorId(movie.getDirectorId());
        movieRepository.save(movie);
    }
    public void deleteMovie(Integer id){
        movieRepository.delete(movieRepository.getMovieById(id));
    }
    //End of CRUD

    //End point 1
    public Movie getMovieByTitle(String name){
        return movieRepository.getMovieByName(name);
    }
    //End point 2
    public Integer getDuration(String name){
        return movieRepository.getMovieByName(name).getDuration();
    }
    //End point 3
    public String getDirectorName(String movieName){
        return directorService.getDirectorById(movieRepository.getMovieByName(movieName).getDirectorId()).getName();
    }
    //End point 4
    public List<Movie> getMoviesByDirector(String directorName){
        return movieRepository.getMoviesByDirectorId(directorService.getDirectorByName(directorName).getId());
    }
    //End point 5
    public Integer getRate(String name){
        return movieRepository.getMovieByName(name).getRating();
    }
    //End point 6
    public List<Movie> getMoviesByRate(Integer rate){
        return movieRepository.getMoviesByRatingGreaterThan(rate);
    }
    //End point 7
    public List<Movie> getMoviesByGenre(String genre){
        return movieRepository.getMoviesByGenre(genre);
    }
    /////END
}
