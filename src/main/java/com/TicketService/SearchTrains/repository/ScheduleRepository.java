package com.TicketService.SearchTrains.repository;

import com.TicketService.SearchTrains.entities.Schedule;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {

    @Query("""
    SELECT s FROM Schedule s
    WHERE s.station.stationId = :stationId
      AND s.platform.platformId = :platformId
      AND s.date = :date
      AND ABS(
        FUNCTION('TIMESTAMPDIFF', MINUTE, s.time, :time)
      ) <= 5
    """)
    List<Schedule> findConflicts(
            String stationId,
            String platformId,
            String date,
            String time
    );
}
