package com.TicketService.SearchTrains.Neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationGRepository extends Neo4jRepository<StationNode,Integer> {

    @Query("""
    MATCH p = shortestPath(
      (s:Station {name: $start})
      -[:ROUTE*]->
      (e:Station {name: $end})
    )
    RETURN nodes(p)
    """)
    List<StationNode> findStationPath(String start, String end);
}
