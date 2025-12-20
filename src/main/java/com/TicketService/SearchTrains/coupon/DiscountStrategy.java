package com.TicketService.SearchTrains.coupon;

public interface DiscountStrategy {
    double applyDiscount(double baseFare, int discount);
}
