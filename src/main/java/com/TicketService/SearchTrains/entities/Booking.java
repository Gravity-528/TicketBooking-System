package com.TicketService.SearchTrains.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    private String bookingId;

    private LocalDateTime startTime;

    private LocalDateTime destinationTime;

    private String status;

    @ManyToOne
    @JoinColumn(name = "trainId")
    private Train train;

    @OneToOne
    @JoinColumn(name="seatId")
    private Seats seat;

    @ManyToOne
    @JoinColumn(name = "couponId")
    private Coupon coupon;

//    @ManyToOne
//    @JoinColumn(name = "userId")
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "scheduleId")
//    private Schedule schedule;
//
//    @OneToOne
//    @JoinColumn(name = "seatId")
//    private Seats seat;

//    @ManyToOne
//    @JoinColumn(name = "couponId")
//    private Coupon coupon;

}
