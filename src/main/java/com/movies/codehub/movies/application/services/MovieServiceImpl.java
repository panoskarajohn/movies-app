package com.movies.codehub.movies.application.services;

import com.movies.codehub.movies.application.base.AbstractLogComponent;
import com.movies.codehub.movies.application.data.PersonnelData;
import com.movies.codehub.movies.application.domain.Movie;
import com.movies.codehub.movies.application.domain.Personnel;
import com.movies.codehub.movies.application.extensions.DataToDomain;
import com.movies.codehub.movies.application.extensions.DomainToData;
import com.movies.codehub.movies.application.repository.MovieRepository;
import com.movies.codehub.movies.application.repository.PersonnelRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl extends AbstractLogComponent implements MovieService {
    private final MovieRepository movieRepository;
    private final PersonnelRepository personnelRepository;

    @Override
    public Movie GetMovie(Long movieId) {
        logger.info("Find movie with id:{}", movieId);
        var movieData = movieRepository
                .findById(movieId).orElseThrow(); // is this acceptable on the service layer?
        var movie = DataToDomain.getMovieWithPersonnelDomain(movieData);
        return movie;
    }

    @Override
    public void RegisterMovies(List<Movie> movies) {
        logger.info("Register movies...");
        var movieData = DomainToData.moviesWithPersonnelData(movies);
        movieRepository.saveAll(movieData);
    }

    @Override
    public long RegisterMovie(Movie movie) {
        logger.info("Register movie...");
        var movieData = DomainToData.movieFromDomain(movie);
        var savedEntity = movieRepository.save(movieData);
        return savedEntity.getId();
    }

    @Override
    public long UpdateMovie(Movie movie) {
        logger.info("Update movie with id:{}", movie.getId());
        var movieData = DomainToData.movieFromDomain(movie);
        var movieDbData = movieRepository.findById(movie.getId()).orElseThrow();
        movieDbData.setTitle(movieData.getTitle());
        movieDbData.setCategory(movieData.getCategory());

        if(movie.getPersonnel() != null || movie.getPersonnel().size() != 0)
        {
            var personnelListData = new ArrayList<PersonnelData>();
            for (var moviePeronnel :
                    movie.getPersonnel()) {
                personnelListData.add(DomainToData.personnelToData(moviePeronnel));
            }

            movieDbData.setPersonnelInMovie(personnelListData);
        }

        movieRepository.save(movieDbData);
        return movieDbData.getId();
    }

    @Override
    public void DeleteMovie(long id) {
        logger.info("Delete movie with id:{}", id);
        movieRepository.deleteById(id);
    }

    @Override
    public long AttachCastToMovie(long id, List<Long> personnelIds) {
        logger.info("Attach cast to movie with id:{}", id);
        var movieDB = movieRepository.findById(id).orElseThrow();

        for (var personnelId :
                personnelIds) {
            var personnelDb = personnelRepository.findById(personnelId).orElseThrow();
            movieDB.AppendPersonnel(personnelDb);
        }

        movieRepository.save(movieDB);
        return id;
    }
}
