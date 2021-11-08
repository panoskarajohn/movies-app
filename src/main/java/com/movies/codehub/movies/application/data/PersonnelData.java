package com.movies.codehub.movies.application.data;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity()
@Table(name = "Personnel")
@Data
public class PersonnelData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    private String type;
    @ManyToMany(mappedBy = "personnelInMovie")
    private List<MovieData> movies = new ArrayList<>();
}
