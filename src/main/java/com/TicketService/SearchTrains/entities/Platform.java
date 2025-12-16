package com.TicketService.SearchTrains.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Platform {

    @Id
    private String platformId;
    private String platfornNo;

    @ManyToOne
    @JoinColumn(name = "StationId")
    private Station station;

}
