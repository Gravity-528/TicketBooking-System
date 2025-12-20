package com.TicketService.SearchTrains.coupon.validation;

import com.TicketService.SearchTrains.entities.Coupon;

public class MinimumFareValidator extends CouponValidator {

    @Override
    public void validate(Coupon coupon, double fare) {
        if (fare < 500) {
            throw new RuntimeException("Minimum fare condition failed");
        }

        if (next != null) next.validate(coupon, fare);
    }
}
