package com.TicketService.SearchTrains.coupon.factory;

import com.TicketService.SearchTrains.coupon.strategy.*;

public class CouponStrategyFactory {

    public static DiscountStrategy getStrategy(String type) {

        if (type.equalsIgnoreCase("PERCENTAGE")) {
            return new PercentageDiscountStrategy();
        }
        if (type.equalsIgnoreCase("FLAT")) {
            return new FlatDiscountStrategy();
        }



        throw new IllegalArgumentException("Invalid coupon type");
    }
}
