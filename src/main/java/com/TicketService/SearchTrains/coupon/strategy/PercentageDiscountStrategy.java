package com.TicketService.SearchTrains.coupon.strategy;

public class PercentageDiscountStrategy implements DiscountStrategy {

    @Override
    public double applyDiscount(double baseFare, int discount) {
        return baseFare - (baseFare * discount / 100.0);
    }
}
