package com.TicketService.SearchTrains.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station {

    @Id
    private String StationId;
    private Integer Longitude;
    private Integer Latitude;
    private String StationName;

    @OneToMany(mappedBy = "station" ,cascade = CascadeType.ALL)
    private List<Platform> platform;

    @OneToMany(mappedBy = "station")
    private List<Schedule> schedule;





}
