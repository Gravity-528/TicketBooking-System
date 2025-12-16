package com.TicketService.SearchTrains.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer scheduleId;
    private String time;
    private String Date;

    @ManyToOne
    @JoinColumn(name = "trainId")
    private Train train;

    @ManyToOne
    @JoinColumn(name = "stationId")
    private Station station;

    @OneToOne
    @JoinColumn(name = "platformId")
    private Platform platform;

    @OneToMany(mappedBy = "schedule")
    private List<Ticket> tickets;


}
