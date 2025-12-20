package com.TicketService.SearchTrains.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SeatDTO {
    private String seatNo;
    private Boolean status;
}
