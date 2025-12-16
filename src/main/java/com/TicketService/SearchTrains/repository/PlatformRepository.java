package com.TicketService.SearchTrains.repository;

import com.TicketService.SearchTrains.entities.Platform;
import com.TicketService.SearchTrains.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatformRepository extends JpaRepository<Platform,String> {

    List<Platform> findByStation(Station station);
}
