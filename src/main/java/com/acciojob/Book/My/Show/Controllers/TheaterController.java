package com.acciojob.Book.My.Show.Controllers;

import com.acciojob.Book.My.Show.Request.AddTheaterRequest;
import com.acciojob.Book.My.Show.Request.AddTheaterSeatsRequest;
import com.acciojob.Book.My.Show.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("/addTheater")
    public String addTheater(@RequestBody AddTheaterRequest addTheaterRequest){

        String result = theaterService.addTheater(addTheaterRequest);
        return result;
    }


    @PostMapping("/addTheaterSeats")
    public String addTheaterSeats(@RequestBody AddTheaterSeatsRequest theaterSeatsRequest){

        String result = theaterService.addTheaterSeats(theaterSeatsRequest);
        return result;
    }
}