package com.acciojob.Book.My.Show.Transformers;

import com.acciojob.Book.My.Show.Entities.Theater;
import com.acciojob.Book.My.Show.Request.AddTheaterRequest;

public class TheaterTransformers {

    public static Theater convertRequestToEntity(AddTheaterRequest theaterRequest){

        Theater theater = Theater.builder()
                .address(theaterRequest.getAddress())
                .noOfScreens(theaterRequest.getNoOfScreens())
                .name(theaterRequest.getName())
                .build();

        return theater;
    }
}
