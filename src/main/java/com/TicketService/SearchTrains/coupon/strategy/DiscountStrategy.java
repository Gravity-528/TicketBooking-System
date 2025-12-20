package com.TicketService.SearchTrains.coupon.strategy;

public interface DiscountStrategy {
    double applyDiscount(double baseFare, int discount);
}
