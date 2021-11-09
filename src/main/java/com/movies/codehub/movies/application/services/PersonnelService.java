package com.movies.codehub.movies.application.services;

import com.movies.codehub.movies.application.domain.Personnel;
import com.movies.codehub.movies.application.extensions.DtoToDomain;

import java.util.List;

public interface PersonnelService {
    public Personnel GetPersonnel(long id);
    public void RegisterPersonnels(List<Personnel> personnels);
    public long RegisterPersonnel(Personnel personnel);
    public long UpdatePersonnel(Personnel personnel);
    public void DeletePersonnel(long id);
}
