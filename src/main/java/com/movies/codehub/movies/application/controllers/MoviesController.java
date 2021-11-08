package com.movies.codehub.movies.application.controllers;

import com.movies.codehub.movies.application.domain.Movie;
import com.movies.codehub.movies.application.services.MovieService;
import com.movies.codehub.movies.application.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MoviesController {

    private final MovieService movieService;


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Movie>> GetMovie(@PathVariable("id") long id)
    {
        var movie = movieService.GetMovie(id);
        return ResponseEntity.ok(ApiResponse.<Movie>builder().data(movie).build());
    }
}
