package com.TicketService.SearchTrains.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    private String ticketId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "scheduleId")
    private Schedule schedule;

    @OneToOne
    @JoinColumn(name = "seatId")
    private Seats seat;

    @ManyToOne
    @JoinColumn(name = "couponId")
    private Coupon coupon;

}
