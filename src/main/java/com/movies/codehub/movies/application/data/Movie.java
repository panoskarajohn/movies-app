package com.movies.codehub.movies.application.data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity()
@Table(name="Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String title;
    String category;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "movie_personnel",
            joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns = @JoinColumn(name = "personnel_id")
    )
    List<Personnel> personnelInMovie = new ArrayList<>();
}
