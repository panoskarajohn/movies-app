package com.movies.codehub.movies.application.services;

import com.movies.codehub.movies.application.base.AbstractLogComponent;
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
public class PersonnelServiceImple extends AbstractLogComponent implements PersonnelService{
    private final PersonnelRepository personnelRepository;

    @Override
    public Personnel GetPersonnel(long id) {
        logger.info("Get movie with id: {}", id);
        var personnelData = personnelRepository
                .findById(id)
                .orElseThrow();
        return DataToDomain.getPersonnelWithAllMovies(personnelData);
    }

    @Override
    public void RegisterPersonnels(List<Personnel> personnels) {
        logger.info("Register personnel...");
        var personnelData = new ArrayList<PersonnelData>();
        for (var personnel :
                personnels) {
            personnelData.add(DomainToData.personnelToData(personnel));
        };
        personnelRepository.saveAll(personnelData);
    }

    @Override
    public long RegisterPersonnel(Personnel personnel) {
        logger.info("Register single personnel");
        var personnelData = DomainToData.personnelToData(personnel);
        var savedPersonnel = personnelRepository.save(personnelData);
        return savedPersonnel.getId();
    }

    @Override
    public long UpdatePersonnel(Personnel personnel) {
        logger.info("Update single personnel with Id: {}", personnel.getId());

        var personnelData = DomainToData.personnelToData(personnel);

        var personnelInDB = personnelRepository
                .findById(personnelData.getId())
                .orElseThrow();

        personnelInDB.setName(personnelData.getName());
        personnelInDB.setAge(personnelData.getAge());
        personnelInDB.setType(personnelData.getType());

        personnelRepository.save(personnelInDB);

        return personnelInDB.getId();
    }

    @Override
    public void DeletePersonnel(long id) {
        logger.info("Delete personnel with id:{}", id);
        personnelRepository.deleteById(id);
    }
}
