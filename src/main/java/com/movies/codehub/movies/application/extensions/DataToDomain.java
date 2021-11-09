package com.movies.codehub.movies.application.extensions;


import com.movies.codehub.movies.application.data.MovieData;
import com.movies.codehub.movies.application.data.PersonnelData;
import com.movies.codehub.movies.application.domain.Movie;
import com.movies.codehub.movies.application.domain.Personnel;
import com.movies.codehub.movies.application.domain.PersonnelType;
import lombok.val;

import java.util.ArrayList;
import java.util.List;

public class DataToDomain {


   public static Movie getMovieWithPersonnelDomain(MovieData movieData)
   {
       return Movie.builder()
               .id(movieData.getId())
               .category(movieData.getCategory())
               .title(movieData.getTitle())
               .personnel(getPersonnelsDomain(movieData.getPersonnelInMovie()))
               .build();
   }

   private static List<Personnel> getPersonnelsDomain(List<PersonnelData> personnelsData)
   {
       val list = new ArrayList<Personnel>();
       for (var personnelData: personnelsData) {
            list.add(getPersonnelDomain(personnelData));
       }
       return list;
   }

   private static Personnel getPersonnelDomain(PersonnelData personnelData)
   {
        return Personnel.builder()
                .name(personnelData.getName())
                .age(personnelData.getAge())
                .id(personnelData.getId())
                .personnelType(PersonnelType.valueOf(personnelData.getType()))
                .build();
   }

   public static Personnel getPersonnelWithAllMovies(PersonnelData personnel)
   {
       var personnelDomain = getPersonnelDomain(personnel);
       var movies = new ArrayList<Movie>();
       for (var movieData :
               personnel.getMovies()) {
           movies.add(getMovieDomain(movieData));
       }
       personnelDomain.setMovies(movies);
       return personnelDomain;
   }

   public static Movie getMovieDomain(MovieData movieData)
   {
       return Movie.builder()
               .id(movieData.getId())
               .category(movieData.getCategory())
               .title(movieData.getTitle())
               .build();
   }
}
