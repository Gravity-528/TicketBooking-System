package com.TicketService.SearchTrains.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Train {

    @Id
    private String trainId;

    private String trainName;
    private String source;
    private String destination;
    private Date arrivalTime;
//    private String endDate;

    @OneToMany(mappedBy = "train")
    private List<Schedule> schedule;

    @OneToMany(mappedBy = "train")
    private List<Seats> seats;
}
