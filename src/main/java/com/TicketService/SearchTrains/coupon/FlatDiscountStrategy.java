package com.TicketService.SearchTrains.coupon;

public class FlatDiscountStrategy implements DiscountStrategy {

    @Override
    public double applyDiscount(double baseFare, int discount) {
        return Math.max(0, baseFare - discount);
    }
}
