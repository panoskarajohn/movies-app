package com.movies.codehub.movies.application.data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity()
@Table(name = "Personnel")
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    private String type;
    @ManyToMany(mappedBy = "personnelInMovie")
    private List<Movie> movies = new ArrayList<>();
}
