package com.movies.codehub.movies.application.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
}
