package com.movies.codehub.movies.application.repository;

import com.movies.codehub.movies.application.data.PersonnelData;
import org.springframework.data.repository.CrudRepository;

public interface PersonnelRepository extends CrudRepository<PersonnelData, Long> {
}
