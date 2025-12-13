package com.TicketService.SearchTrains.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
