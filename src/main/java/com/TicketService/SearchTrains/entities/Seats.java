package com.TicketService.SearchTrains.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seats {

    @Id
    private String seatId;
    private Integer price;
    private String status;
    private String date;

    @ManyToOne
    @JoinColumn(name = "trainId")
    private Train train;

}
