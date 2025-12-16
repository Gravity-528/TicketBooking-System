package com.TicketService.SearchTrains.Neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationGRepository extends Neo4jRepository<StationNode,Integer> {
}
