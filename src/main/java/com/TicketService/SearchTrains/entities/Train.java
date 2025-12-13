package com.TicketService.SearchTrains.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Train {

    @Id
    private String TrainId;

    private String TrainName;
    private String Source;
    private String Destination;
    private String ArrivalTime;
    private String startDate;
    private String endDate;

    @OneToMany(mappedBy = "train")
    private List<Schedule> schedule;

    @OneToMany(mappedBy = "train")
    private List<Seats> seats;
}
