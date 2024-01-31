package com.acciojob.Book.My.Show.Request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AddShowRequest {
    private LocalDate showDate;

    private LocalTime showTime;

    private String movieName; //From this name we will figure out MovieEntity

    private int theaterId;
}
