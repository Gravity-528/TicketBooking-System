package com.TicketService.SearchTrains.service;

import com.TicketService.SearchTrains.Neo4j.StationGRepository;
import com.TicketService.SearchTrains.Neo4j.StationNode;
import com.TicketService.SearchTrains.Utils.DistanceUtil;
import com.TicketService.SearchTrains.Utils.GeoUtils;
import com.TicketService.SearchTrains.entities.Platform;
import com.TicketService.SearchTrains.entities.Schedule;
import com.TicketService.SearchTrains.entities.Station;
import com.TicketService.SearchTrains.entities.Train;
import com.TicketService.SearchTrains.repository.PlatformRepository;
import com.TicketService.SearchTrains.repository.ScheduleRepository;
import com.TicketService.SearchTrains.repository.StationRepository;
import com.TicketService.SearchTrains.repository.TrainRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private StationGRepository graphRepo;

    @Autowired
    private StationRepository stationRepo;

    @Autowired
    private PlatformRepository platformRepo;

    @Autowired
    private ScheduleRepository scheduleRepo;

    public List<Train> findAllTrain() {
        return trainRepository.findAll();
    }

    @Transactional
    public void createRoute(
            String startStation,
            String endStation,
            LocalDate startDate,
            LocalTime startTime,
            Train train
    ) {


        List<StationNode> path =
                graphRepo.findStationPath(startStation, endStation);

        LocalDateTime currentDateTime =
                LocalDateTime.of(startDate, startTime);

        for (int i = 0; i < path.size(); i++) {

            StationNode currentNode = path.get(i);

            Station station = stationRepo
                    .findById(currentNode.getStationId())
                    .orElseThrow(() -> new RuntimeException("Station not found"));


            if (i > 0) {
                StationNode previousNode = path.get(i - 1);

                double distance =
                        GeoUtils.distance(
                                previousNode.getLatitude(),
                                previousNode.getLongitude(),
                                currentNode.getLatitude(),
                                currentNode.getLongitude()
                        );

                long minutes =
                        DistanceUtil.travelMinutes(
                                distance,
                                100
                        );

                currentDateTime = currentDateTime.plusMinutes(minutes);
            }


            Platform platform =
                    assignPlatform(station, currentDateTime);


            Schedule schedule = new Schedule();
            schedule.setTrain(train);
            schedule.setStation(station);
            schedule.setPlatform(platform);
            schedule.setTime(currentDateTime.toLocalTime().toString());
            schedule.setDate(currentDateTime.toLocalDate().toString());

            scheduleRepo.save(schedule);
        }
    }


    private Platform assignPlatform(
            Station station,
            LocalDateTime arrivalDateTime
    ) {

        List<Platform> platforms =
                platformRepo.findByStation(station);

        for (Platform platform : platforms) {

            List<Schedule> conflicts =
                    scheduleRepo.findConflicts(
                            station.getStationId(),
                            platform.getPlatformId(),
                            arrivalDateTime.toLocalDate().toString(),
                            arrivalDateTime.toLocalTime().toString()
                    );

            if (conflicts.isEmpty()) {
                return platform;
            }
        }

        throw new RuntimeException(
                "No platform available at station: " + station.getStationName()
        );
    }
}
