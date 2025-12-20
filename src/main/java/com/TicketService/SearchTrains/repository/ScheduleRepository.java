package com.TicketService.SearchTrains.repository;

import com.TicketService.SearchTrains.entities.Schedule;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TicketService.SearchTrains.DTO.SchedulePairDTO;

import java.time.LocalDateTime;
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

    @Query("""
    SELECT new SchedulePairDTO(S1, S2)
    FROM Schedule S1, Scheule S2
    WHERE S1.train.trainId = S2.train.trainId
      AND S1.time < S2.time
      AND S1.time > :nowTime
      AND S1.station.stationName = :source
      AND S2.station.stationName = :detination
    """)
    List<SchedulePairDTO> fetchSchedule(
            @Param("nowTime") LocalDateTime nowTime,
            @Param("source") String source,
            @Param("destination") String destination
    );
}
