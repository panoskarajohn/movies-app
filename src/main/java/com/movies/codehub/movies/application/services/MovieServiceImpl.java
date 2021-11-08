package com.movies.codehub.movies.application.services;

import com.movies.codehub.movies.application.domain.Movie;
import com.movies.codehub.movies.application.domain.Personnel;
import com.movies.codehub.movies.application.extensions.DomainToData;
import com.movies.codehub.movies.application.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{
    private final MovieRepository movieRepository;

    @Override
    public List<Movie> GetMovie(Long movieId) {
        return null;
    }

    @Override
    public List<Personnel> GetActors(Long movieId) {
        return null;
    }

    @Override
    public List<Personnel> GetActorMovies(Long personnelId) {
        return null;
    }

    @Override
    public void RegisterMovies(List<Movie> movies) {
        var movieData = DomainToData.moviesWithPersonnelData(movies);
        movieRepository.saveAll(movieData);
    }
}
