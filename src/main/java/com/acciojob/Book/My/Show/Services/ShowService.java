package com.acciojob.Book.My.Show.Services;

import com.acciojob.Book.My.Show.CustomException.InvalidMovieException;
import com.acciojob.Book.My.Show.CustomException.InvalidTheaterException;
import com.acciojob.Book.My.Show.Entities.*;
import com.acciojob.Book.My.Show.Enums.SeatType;
import com.acciojob.Book.My.Show.Repository.MovieRepository;
import com.acciojob.Book.My.Show.Repository.ShowRepository;
import com.acciojob.Book.My.Show.Repository.ShowSeatRepository;
import com.acciojob.Book.My.Show.Repository.TheaterRepository;
import com.acciojob.Book.My.Show.Request.AddShowRequest;
import com.acciojob.Book.My.Show.Request.AddShowSeatsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private MovieRepository movieRepository;

    public String addShow(AddShowRequest showRequest) throws Exception{
        Movie movie = movieRepository.findMovieByMovieName(showRequest.getMovieName());

        if(movie==null)
            throw new InvalidMovieException("Movie Name entered does not exist in the DB");

        Optional<Theater> theaterOptional = theaterRepository.findById(showRequest.getTheaterId());
        if (theaterOptional.isEmpty())
            throw new InvalidTheaterException("Theater Id entered is incorrect");

        Theater theater = theaterOptional.get();

        //Ideally you should create the show Entity with the help of Transformers
        Show showEntity = new Show(showRequest.getShowDate(), showRequest.getShowTime());

        showEntity.setMovie(movie);
        showEntity.setTheater(theater);

        //Bidirectional in the parent class
        movie.getShowList().add(showEntity);
        theater.getShowList().add(showEntity);
        showEntity = showRepository.save(showEntity);
        return "The show has been created with the showId "+showEntity.getShowId();
    }

    public String addShowSeats(AddShowSeatsRequest addShowSeatsRequest) {
        Show show = showRepository.findById(addShowSeatsRequest.getShowId()).get();
        Theater theater = show.getTheater();
        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

        List<ShowSeat> showSeatList = new ArrayList<>();

        for(TheaterSeat theaterSeat : theaterSeatList){

            String seatNo = theaterSeat.getSeatNo();
            SeatType seatType = theaterSeat.getSeatType();

            ShowSeat showSeat = ShowSeat.builder()
                    .foodAttached(false)
                    .isAvailable(true)
                    .show(show)
                    .seatNo(seatNo)
                    .seatType(seatType)
                    .build();

            if(seatType.equals(SeatType.CLASSIC))
                showSeat.setPrice(addShowSeatsRequest.getPriceForClassicSeats());
            else
                showSeat.setPrice(addShowSeatsRequest.getPriceForPremiumSeats());

            showSeatList.add(showSeat);
        }
        showSeatRepository.saveAll(showSeatList);

        return "Show seats have been added to the system";
    }
}
