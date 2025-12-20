package com.TicketService.SearchTrains.service;

import com.TicketService.SearchTrains.DTO.SeatDTO;
import com.TicketService.SearchTrains.repository.BookingRepository;
import com.TicketService.SearchTrains.repository.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    private BookingRepository bookingRepository;
    private SeatsRepository seatsRepository;

    private List<SeatDTO> findSeatStatus(String trainId,String source,String destination){

    }
}
