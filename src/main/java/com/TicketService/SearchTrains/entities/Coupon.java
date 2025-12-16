package com.TicketService.SearchTrains.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {

    @Id
    private String couponId;
    private String description;
    private Integer discountPercentage;

    @OneToMany(mappedBy = "coupon")
    private List<Ticket> tickets;



}
