package com.TicketService.SearchTrains.service;

import com.TicketService.SearchTrains.entities.Train;
import com.TicketService.SearchTrains.repository.ScheduleRepository;
import com.TicketService.SearchTrains.repository.Trainrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    private Trainrepository trainrepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Train FindTrainById(String id){
        return trainrepository.FindTrainById(id);
    }

    public List<Train> FindAllTrain(){
        return trainrepository.findAll();
    }

//    public List<Train> AllTrainInfo(String start,String end){
//        return
//    }
}
