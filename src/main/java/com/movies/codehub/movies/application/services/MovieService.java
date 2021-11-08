package com.movies.codehub.movies.application.services;

import com.movies.codehub.movies.application.domain.Movie;
import com.movies.codehub.movies.application.domain.Personnel;

import java.util.List;

public interface MovieService {
    public Movie GetMovie(Long movieId);
    public List<Personnel> GetActors(Long movieId);
    public List<Personnel> GetActorMovies(Long personnelId);
    public void RegisterMovies(List<Movie> movies);
}
