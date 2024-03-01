package com.acciojob.Book.My.Show.Controllers;

import com.acciojob.Book.My.Show.Request.AddTheaterRequest;
import com.acciojob.Book.My.Show.Request.AddTheaterSeatsRequest;
import com.acciojob.Book.My.Show.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("removeTheater")
    public ResponseEntity removeTheater(@RequestParam("theaterId") Integer theaterId){
        try {
            String result = theaterService.removeTheater(theaterId);
            return new ResponseEntity(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/addTheaterSeats")
    public String addTheaterSeats(@RequestBody AddTheaterSeatsRequest theaterSeatsRequest){

        String result = theaterService.addTheaterSeats(theaterSeatsRequest);
        return result;
    }
}