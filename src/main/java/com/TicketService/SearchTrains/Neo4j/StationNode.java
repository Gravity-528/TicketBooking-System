package com.TicketService.SearchTrains.Neo4j;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node("Station")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StationNode {

    @Id
    private String stationId;

    private String stationName;
    private double latitude;
    private double longitude;

    @Relationship(type = "ROUTE")
    private List<Route> routes = new ArrayList<>();
}
