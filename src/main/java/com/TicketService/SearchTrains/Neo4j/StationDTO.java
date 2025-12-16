package com.TicketService.SearchTrains.Neo4j;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationDTO {
    private String id;
    private String name;
    private double latitude;
    private double longitude;
}
