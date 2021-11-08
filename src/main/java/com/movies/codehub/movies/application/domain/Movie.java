package com.movies.codehub.movies.application.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.util.List;

@Data
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Movie extends BaseEntity {
    private String title;
    private String category;
    private List<Actor> actors;
}
