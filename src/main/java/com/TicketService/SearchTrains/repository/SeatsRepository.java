package com.TicketService.SearchTrains.repository;

import com.TicketService.SearchTrains.entities.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatsRepository extends JpaRepository<Seats,String> {
}
