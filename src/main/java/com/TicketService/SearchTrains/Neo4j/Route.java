package com.TicketService.SearchTrains.Neo4j;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Route {

    @Id
    @GeneratedValue
    private Long id;

    private double distanceKm;

    @TargetNode
    private StationNode destination;
}

