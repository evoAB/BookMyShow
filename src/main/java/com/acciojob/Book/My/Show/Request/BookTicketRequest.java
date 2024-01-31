package com.acciojob.Book.My.Show.Request;

import com.acciojob.Book.My.Show.Enums.SeatType;
import lombok.Data;

import java.util.List;

@Data
public class BookTicketRequest {
    public int showId;
    public List<String> seatList;
    private SeatType seatType;
    public String emailId; //You can take the userId
}
