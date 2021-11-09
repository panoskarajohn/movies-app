package com.movies.codehub.movies.application.controllers;

import com.movies.codehub.movies.application.domain.Movie;
import com.movies.codehub.movies.application.dto.MovieDto;
import com.movies.codehub.movies.application.dto.PersonnelDto;
import com.movies.codehub.movies.application.extensions.DtoToDomain;
import com.movies.codehub.movies.application.services.MovieService;
import com.movies.codehub.movies.application.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

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

    @PostMapping
    public ResponseEntity CreateMovie(@RequestBody MovieDto movieDto)
    {
        val movie = DtoToDomain.MovieDtoToDomain(movieDto);
        val id = movieService.RegisterMovie(movie);

        val uri = UriComponentsBuilder.fromPath("movies/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity UpdateMovie(@RequestBody MovieDto movieDto){
        val movie = DtoToDomain.MovieDtoToDomain(movieDto);
        val id = movieService.UpdateMovie(movie);
        val uri = UriComponentsBuilder.fromPath("movies/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity DeleteMovie(@PathVariable("id") long id)
    {
        movieService.DeleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/appendcast")
    public ResponseEntity UpdateCast(@PathVariable("id") long id,@RequestBody List<Long> personnelids)
    {
        var movie = movieService.GetMovie(id);

        if (movie == null)
            return ResponseEntity.notFound().build();

        movieService.AttachCastToMovie(id, personnelids);
        val uri = UriComponentsBuilder.fromPath("movies/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }
}
