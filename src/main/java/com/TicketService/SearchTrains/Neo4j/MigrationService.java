package com.TicketService.SearchTrains.Neo4j;

import com.TicketService.SearchTrains.Utils.GeoUtils;
import com.TicketService.SearchTrains.entities.Station;
import com.TicketService.SearchTrains.repository.StationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class MigrationService {

    private final StationRepository jpaRepo;
    private final StationGRepository neo4jRepo;
    private final JsonReader jsonReader;

    public MigrationService(
            StationRepository jpaRepo,
            StationGRepository neo4jRepo,
            JsonReader jsonReader
    ) {
        this.jpaRepo = jpaRepo;
        this.neo4jRepo = neo4jRepo;
        this.jsonReader = jsonReader;
    }

    public void createNearestRoutes(List<StationNode> stations) {

        for (StationNode source : stations) {

            List<StationNode> nearest = stations.stream()
                    .filter(target -> !target.getStationId().equals(source.getStationId()))
                    .sorted(Comparator.comparingDouble(
                            target -> GeoUtils.distance(
                                    source.getLatitude(),
                                    source.getLongitude(),
                                    target.getLatitude(),
                                    target.getLongitude()
                            )
                    ))
                    .limit(2)
                    .toList();

            for (StationNode target : nearest) {

                double distance = GeoUtils.distance(
                        source.getLatitude(),
                        source.getLongitude(),
                        target.getLatitude(),
                        target.getLongitude()
                );

                Route route = new Route();
                route.setDistanceKm(distance);
                route.setDestination(target);

                source.getRoutes().add(route);
            }

            neo4jRepo.save(source);
        }
    }


    public void migrate() throws Exception {

        List<StationDTO> stations = jsonReader.readStations();

        List<StationNode> nodes = new ArrayList<>();

        for (StationDTO dto : stations) {

            // Save to MySQL
            Station entity = new Station();
            entity.setStationId(dto.getId());
            entity.setStationName(dto.getName());
            entity.setLatitude(dto.getLatitude());
            entity.setLongitude(dto.getLongitude());
            jpaRepo.save(entity);

            // Save to Neo4j
            StationNode node = new StationNode();
            node.setStationId(dto.getId());
            node.setStationName(dto.getName());
            node.setLatitude(dto.getLatitude());
            node.setLongitude(dto.getLongitude());
            neo4jRepo.save(node);

            nodes.add(neo4jRepo.save(node));
        }
        createNearestRoutes(nodes);
    }
}

