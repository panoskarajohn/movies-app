package com.movies.codehub.movies.application.bootstrap;

import com.movies.codehub.movies.application.domain.Movie;
import com.movies.codehub.movies.application.domain.Personnel;
import com.movies.codehub.movies.application.domain.PersonnelType;
import com.movies.codehub.movies.application.services.MovieService;
import com.movies.codehub.movies.application.services.PersonnelService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("movies")
@RequiredArgsConstructor
public class GenerateContent implements CommandLineRunner {
    private final MovieService movieService;
    private final PersonnelService personnelService;

    @Override
    public void run(String... args) {
        generateMoviesWithCast();
    }
    Personnel harrisonFord = Personnel.builder().id(1L).name("Harrison Ford").age(79).personnelType(PersonnelType.ACTOR).build();
    private void generateMoviesWithCast() {
        List<Personnel> bladeRunnerPersonnel = List.of(
                harrisonFord,
                Personnel.builder().id(2L).name("Ridley Scott").age(83).personnelType(PersonnelType.DIRECTOR).build()
        );

        List<Personnel> starWarsPersonnel = List.of(
                harrisonFord,
                Personnel.builder().id(3L).name("Mark Hammil").age(70).personnelType(PersonnelType.ACTOR).build(),
                Personnel.builder().id(4L).name("George Lucas").age(77).personnelType(PersonnelType.DIRECTOR).build()
        );

        personnelService.RegisterPersonnels(bladeRunnerPersonnel);
        personnelService.RegisterPersonnels(starWarsPersonnel);

        List<Movie> movies = List.of(
                Movie.builder().id(10L).title("Blade Runner").category("ScienceFiction").personnel(bladeRunnerPersonnel).build(),
                Movie.builder().id(20L).title("Star Wars").category("ScienceFiction").personnel(starWarsPersonnel).build()
        );

        movieService.RegisterMovies(movies);
    }


}
