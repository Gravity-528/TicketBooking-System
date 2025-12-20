package com.TicketService.SearchTrains.DTO;

import com.TicketService.SearchTrains.entities.Schedule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulePairDTO {

    private Schedule source;
    private Schedule destination;

}
