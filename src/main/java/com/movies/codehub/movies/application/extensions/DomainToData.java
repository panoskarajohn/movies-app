package com.movies.codehub.movies.application.extensions;

import com.movies.codehub.movies.application.data.MovieData;
import com.movies.codehub.movies.application.data.PersonnelData;
import com.movies.codehub.movies.application.domain.Movie;
import com.movies.codehub.movies.application.domain.Personnel;
import lombok.val;

import java.util.ArrayList;
import java.util.List;

public class DomainToData {

    public static List<MovieData> moviesWithPersonnelData(List<Movie> movies)
    {
        val movieDataList = new ArrayList<MovieData>();
        for (val movie : movies) {
            movieDataList.add(movieWithPersonnelToData(movie));
        }
        return movieDataList;
    }

    public static PersonnelData personnelToData(Personnel personnel)
    {
        val personnelData = new PersonnelData();
        personnelData.setId(personnel.getId());
        personnelData.setName(personnel.getName());
        personnelData.setAge(personnel.getAge());
        personnelData.setType(personnel.getPersonnelType().toString());
        return personnelData;
    }

    private static MovieData movieWithPersonnelToData(Movie movie)
    {
        var movieData = new MovieData();
        movieData.setId(movie.getId());
        movieData.setTitle(movie.getTitle());
        movieData.setCategory(movie.getCategory());
        movieData.setPersonnelInMovie(personnelsToData(movie.getPersonnel()));
        return movieData;
    }

    private static List<PersonnelData> personnelsToData(List<Personnel> personnelList)
    {
        var personnelsData = new ArrayList<PersonnelData>();
        for (var personnel : personnelList) {
            var personnelData = new PersonnelData();
            personnelData.setId(personnel.getId());
            personnelData.setType(personnel.getPersonnelType().toString());
            personnelData.setName(personnel.getName());
            personnelData.setAge(personnel.getAge());
            personnelsData.add(personnelData);
        }
        return personnelsData;
    }
}
