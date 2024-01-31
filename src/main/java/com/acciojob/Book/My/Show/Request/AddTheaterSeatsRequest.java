package com.acciojob.Book.My.Show.Request;

import lombok.Data;

@Data
public class AddTheaterSeatsRequest {

    private int noOfClassicSeats;
    private int noOfPremiumSeats;
    private int theaterId;
}
