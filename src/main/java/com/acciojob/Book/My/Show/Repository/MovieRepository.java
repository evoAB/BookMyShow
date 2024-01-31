package com.acciojob.Book.My.Show.Repository;

import com.acciojob.Book.My.Show.Entities.Movie;
import com.acciojob.Book.My.Show.Enums.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    //2nd type of fetch where you just define the method
    //no query nothing
    //but naming of the method has to be strict
    Movie findMovieByMovieNameAndAndMovieLanguage(String movieName, Language language);

    Movie findMovieByMovieName(String movieName);

    List<Movie> findAllByDurationGreaterThanEqual(double duration);
}
