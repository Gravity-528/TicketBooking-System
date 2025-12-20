package com.TicketService.SearchTrains.coupon.validation;

import com.TicketService.SearchTrains.entities.Coupon;

public class UsageValidator extends CouponValidator {

    @Override
    public void validate(Coupon coupon, double fare) {
        boolean alreadyUsed = false; // DB check

        if (alreadyUsed) {
            throw new RuntimeException("Coupon already used");
        }

        if (next != null) next.validate(coupon, fare);
    }
}
