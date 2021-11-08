package com.movies.codehub.movies.application.repository;


import com.movies.codehub.movies.application.data.MovieData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<MovieData,Long> {
}
