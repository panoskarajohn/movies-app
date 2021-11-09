package com.movies.codehub.movies.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonnelDto {
    private long id;
    private String name;
    private int age;
    private String personnelType;
}
