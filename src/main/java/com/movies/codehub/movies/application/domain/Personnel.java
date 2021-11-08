package com.movies.codehub.movies.application.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Personnel extends BaseEntity{
    private String name;
    private int age;
    private PersonnelType personnelType;
    private List<Movie> movies;
}
