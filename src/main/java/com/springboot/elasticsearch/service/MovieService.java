package com.springboot.elasticsearch.service;

import com.springboot.elasticsearch.model.Director;
import com.springboot.elasticsearch.model.Movie;
import com.springboot.elasticsearch.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getByName(String name) {
        return movieRepository.findByName(name);
    }

    public List<Movie> getByRatingInterval(Double start, Double end) {
        return movieRepository.findByRatingBetween(start, end);
    }

    public List<Movie> findByDirector(Director director) {
        return movieRepository.findByDirector(director);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if(movie.isPresent()) {
            Movie deletedMovie = movie.get();
            movieRepository.delete(deletedMovie);
        }
    }

    public Page<Movie> allMovies(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    public void update(Long id,Movie movieForUpdate) {

        movieRepository.findById(id).ifPresentOrElse(movie -> {
            movie.setName(movieForUpdate.getName());
            movie.setRating(movieForUpdate.getRating());
            movie.setGenre(movieForUpdate.getGenre());
            movie.setDirector(movieForUpdate.getDirector());
        }, () -> {
            throw new RuntimeException("No Record With this Id!");
                }
        );
    }

}
