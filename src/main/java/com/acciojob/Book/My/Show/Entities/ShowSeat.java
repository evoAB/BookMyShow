package com.acciojob.Book.My.Show.Entities;

import com.acciojob.Book.My.Show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "show_seats")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;

    private int price;

    private boolean isAvailable;

    private boolean foodAttached;

    private String seatNo; //These values will

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType; //come from the theater seats
    //based on mapping or seat structure

    @JoinColumn
    @ManyToOne
    private Show show;

}
