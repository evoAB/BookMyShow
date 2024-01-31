package com.acciojob.Book.My.Show.Request;

import com.acciojob.Book.My.Show.Enums.Genre;
import com.acciojob.Book.My.Show.Enums.Language;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddMovieRequest {

    private String movieName;
    private Genre genre;
    private Language movieLanguage;
    private LocalDate releaseDate;
    private double duration;
    private double rating;
}
