package com.TicketService.SearchTrains.repository;

import com.TicketService.SearchTrains.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

    @Query("""
        SELECT b FROM Booking b
        WHERE b.startTime <= :time
          AND b.destinationTime >= :time
          AND b.train.trainName = :trainName
          AND (b.status = 'Booked' OR b.status = 'Pending')
    """)
    List<Booking> findBookedOrPendingBookings(
            @Param("time") LocalDateTime time,
            @Param("trainName") String trainName
    );
}
