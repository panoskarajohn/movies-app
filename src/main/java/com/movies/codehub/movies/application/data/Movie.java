package com.movies.codehub.movies.application.data;

import com.movies.codehub.movies.application.domain.Actor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Movie")
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String title;
    String category;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "movie_actor", joinColumns = @JoinColumn(name="movie_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
    List<Actor> actors = new ArrayList<>();
}
