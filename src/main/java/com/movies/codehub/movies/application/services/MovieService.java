package com.movies.codehub.movies.application.services;

import com.movies.codehub.movies.application.domain.Movie;
import com.movies.codehub.movies.application.domain.Personnel;

import java.util.List;

public interface MovieService {
    public Movie GetMovie(Long movieId);
    public void RegisterMovies(List<Movie> movies);
    public long RegisterMovie(Movie movie);
    public long UpdateMovie(Movie movie);
    public void DeleteMovie(long id);
    public long AttachCastToMovie(long id, List<Long> personnelIds);
}
