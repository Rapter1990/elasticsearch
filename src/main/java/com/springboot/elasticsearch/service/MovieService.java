package com.springboot.elasticsearch.service;

import com.springboot.elasticsearch.model.Director;
import com.springboot.elasticsearch.model.Movie;
import com.springboot.elasticsearch.repository.MovieRepository;
import com.springboot.elasticsearch.util.Constants;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;


@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Optional<Movie> findById(String id) {
        return movieRepository.findById(id);
    }

    public List<Movie> getByName(String name) {
        return movieRepository.findByName(name);
    }

    public List<Movie> getByRatingInterval(Double start, Double end) {
        return movieRepository.findByRatingBetween(start, end);
    }

    public Page<Movie> findByDirector(String search) {

        QueryBuilder queryBuilder = QueryBuilders.nestedQuery(
                "director",
                QueryBuilders.boolQuery().must(QueryBuilders.matchQuery(Constants.MOVIE_DIRECTOR, search)),
                ScoreMode.None);

        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();
        return movieRepository.search(searchQuery);
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(String id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if(movie.isPresent()) {
            Movie deletedMovie = movie.get();
            movieRepository.delete(deletedMovie);
        }
    }

    public List<Movie> allMovies() {
        List<Movie> employees = new ArrayList<>();
        movieRepository.findAll().forEach(employees::add);
        return employees;
    }

    public void update(String id,Movie movieForUpdate) {

        movieRepository.findById(id).ifPresentOrElse(movie -> {
            movie.setName(movieForUpdate.getName());
            movie.setRating(movieForUpdate.getRating());
            movie.setGenre(movieForUpdate.getGenre());
            movie.setDirector(movieForUpdate.getDirector());
            movieRepository.save(movie);
        }, () -> {
            throw new RuntimeException("No Record With this Id!");
                }
        );
    }

    public Page<Movie> searchMovieName(String search) {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchQuery(Constants.MOVIE_NAME, search))
                .build();
        return movieRepository.search(searchQuery);
    }

    public Page<Movie> searchMovieWithFuzzines(String search) {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchQuery(Constants.MOVIE_NAME, search)
                        .operator(Operator.AND)
                        .fuzziness(Fuzziness.AUTO) // change any uppercase or lowercase letter
                        .prefixLength(3)) // not changed in first 3 letters of search text
                .build();
        return movieRepository.search(searchQuery);
    }

    public Page<Movie> searchMovieWithMultiMatch(String search) {


        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(multiMatchQuery(search)
                        .field(Constants.MOVIE_NAME)
                        .field(Constants.MOVIE_ID)
                        .type(MultiMatchQueryBuilder.Type.BEST_FIELDS))
                .build();
        return movieRepository.search(searchQuery);
    }

    public Page<Movie> searchMovieWithPhraseQuery(String search) {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchPhraseQuery(Constants.MOVIE_NAME, search).slop(1))
                .build();
        return movieRepository.search(searchQuery);
    }

}
