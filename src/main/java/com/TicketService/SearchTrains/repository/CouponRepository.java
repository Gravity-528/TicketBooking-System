package com.TicketService.SearchTrains.repository;

import com.TicketService.SearchTrains.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,String> {
}
