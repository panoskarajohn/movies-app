package com.movies.codehub.movies.application.services;

import com.movies.codehub.movies.application.domain.Personnel;

import java.util.List;

public interface PersonnelService {
    public Personnel GetPersonnel(long id);
    public void RegisterPersonnel(List<Personnel> personnels);

}
