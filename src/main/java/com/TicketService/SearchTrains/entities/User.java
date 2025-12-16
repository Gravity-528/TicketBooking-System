package com.TicketService.SearchTrains.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String userId;
    private String name;
    private String username;
    private String password;
    private String role;

    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets;



}
