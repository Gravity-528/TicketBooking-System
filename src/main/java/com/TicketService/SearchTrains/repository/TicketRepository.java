package com.TicketService.SearchTrains.repository;

import com.TicketService.SearchTrains.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,String> {
}
