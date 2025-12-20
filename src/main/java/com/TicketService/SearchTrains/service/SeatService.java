package com.TicketService.SearchTrains.service;

import com.TicketService.SearchTrains.DTO.SeatDTO;
import com.TicketService.SearchTrains.entities.Booking;
import com.TicketService.SearchTrains.entities.Seats;
import com.TicketService.SearchTrains.repository.BookingRepository;
import com.TicketService.SearchTrains.repository.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SeatService {

    @Autowired
    private BookingRepository bookingRepository;
    private SeatsRepository seatsRepository;

    private List<SeatDTO> findSeatStatus(LocalDateTime time,String trainName){
       List<Booking> occupiedSeat=bookingRepository.findBookedOrPendingBookings(time,trainName);
       Set<String> checkedSeat=new HashSet<>();

        for (Booking booking : occupiedSeat) {
            checkedSeat.add(booking.getSeat().getSeatId());
        }

       List<Seats> allSeat=seatsRepository.findAll();
        List<SeatDTO> seatStatus=new ArrayList<>();

        for (Seats seats : allSeat) {
            if (checkedSeat.contains(seats.getSeatId())) {
               seatStatus.add(new SeatDTO(seats.getSeatId(), true));
            }
            else{
                seatStatus.add(new SeatDTO(seats.getSeatId(), false));
            }
        }

        return seatStatus;

    }
}
