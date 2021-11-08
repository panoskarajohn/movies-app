package com.movies.codehub.movies.application.services;

import com.movies.codehub.movies.application.data.PersonnelData;
import com.movies.codehub.movies.application.domain.Personnel;
import com.movies.codehub.movies.application.extensions.DataToDomain;
import com.movies.codehub.movies.application.extensions.DomainToData;
import com.movies.codehub.movies.application.repository.PersonnelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonnelServiceImple implements PersonnelService{
    private final PersonnelRepository personnelRepository;

    @Override
    public Personnel GetPersonnel(long id) {
        var personnelData = personnelRepository.findById(id).orElseThrow();
        return DataToDomain.getPersonnelWithAllMovies(personnelData);
    }

    @Override
    public void RegisterPersonnel(List<Personnel> personnels) {
        var personnelData = new ArrayList<PersonnelData>();
        for (var personnel :
                personnels) {
            personnelData.add(DomainToData.personnelToData(personnel));
        };
        personnelRepository.saveAll(personnelData);
    }
}
