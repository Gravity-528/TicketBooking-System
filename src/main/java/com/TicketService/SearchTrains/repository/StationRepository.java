package com.TicketService.SearchTrains.repository;

import com.TicketService.SearchTrains.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station,String> {
    Station findByStationName(String stationName);
}
