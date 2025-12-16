package com.TicketService.SearchTrains.service;

import com.TicketService.SearchTrains.entities.Train;
import com.TicketService.SearchTrains.repository.ScheduleRepository;
import com.TicketService.SearchTrains.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;




    public List<Train> FindAllTrain(){
        return trainRepository.findAll();
    }

//    public List<Train> AllTrainInfo(String start,String end){
//        return
//    }
}
