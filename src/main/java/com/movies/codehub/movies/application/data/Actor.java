package com.movies.codehub.movies.application.data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Actor")
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies = new ArrayList<>();
}
