package com.TicketService.SearchTrains.repository;

import com.TicketService.SearchTrains.entities.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Trainrepository extends JpaRepository<Train,String> {
    public Train FindTrainById(String Id);
}
