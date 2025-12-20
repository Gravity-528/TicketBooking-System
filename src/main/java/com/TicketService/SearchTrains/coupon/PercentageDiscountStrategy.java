package com.TicketService.SearchTrains.coupon;

public class PercentageDiscountStrategy implements DiscountStrategy {

    @Override
    public double applyDiscount(double baseFare, int discount) {
        return baseFare - (baseFare * discount / 100.0);
    }
}
