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
    private String SeatId;
    private Integer price;
    private String status;
    private String date;

    @ManyToOne
    @JoinColumn(name = "trainId")
    private Train train;

    @OneToOne
    @JoinColumn(name = "ticketId",unique = true)
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "userId",unique = true)
    private User user;
}
