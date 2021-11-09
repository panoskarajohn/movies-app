package com.movies.codehub.movies.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieDto {
    private long id;
    private String title;
    private String category;
}
