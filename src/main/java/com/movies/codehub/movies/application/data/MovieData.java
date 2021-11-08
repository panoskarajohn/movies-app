package com.movies.codehub.movies.application.data;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity()
@Table(name="Movie")
@Access(value=AccessType.FIELD)
@Data
public class MovieData {
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
    List<PersonnelData> personnelInMovie = new ArrayList<>();
}
