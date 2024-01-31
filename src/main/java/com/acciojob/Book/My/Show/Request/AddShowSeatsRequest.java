package com.acciojob.Book.My.Show.Request;

import lombok.Data;

@Data
public class AddShowSeatsRequest {

    private int priceForClassicSeats;
    private int priceForPremiumSeats;
    private int showId;
}
