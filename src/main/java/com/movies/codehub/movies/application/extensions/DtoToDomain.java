package com.movies.codehub.movies.application.extensions;

import com.movies.codehub.movies.application.domain.Movie;
import com.movies.codehub.movies.application.domain.Personnel;
import com.movies.codehub.movies.application.domain.PersonnelType;
import com.movies.codehub.movies.application.dto.MovieDto;
import com.movies.codehub.movies.application.dto.PersonnelDto;

import java.util.Locale;

public class DtoToDomain {

    public static Movie MovieDtoToDomain(MovieDto movieDto)
    {
        return Movie.builder()
                .id(movieDto.getId())
                .title(movieDto.getTitle())
                .category(movieDto.getCategory())
                .build();
    }

    public static Personnel PersonnelDtoToDomain(PersonnelDto personnelDto)
    {
        return Personnel.builder()
                .id(personnelDto.getId())
                .age(personnelDto.getAge())
                .name(personnelDto.getName())
                .personnelType(PersonnelType.valueOf(personnelDto.getPersonnelType().toUpperCase(Locale.ROOT)))
                .build();
    }
}
