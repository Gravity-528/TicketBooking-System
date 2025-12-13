package com.TicketService.SearchTrains.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ScheduleId;
    private String time;
    private String Date;
    private String PlatformAssigned;

    @ManyToOne
    @JoinColumn(name = "TrainId")
    private Train train;

    @ManyToOne
    @JoinColumn(name = "StationId")
    private Station station;
}
