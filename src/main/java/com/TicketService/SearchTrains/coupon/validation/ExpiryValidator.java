package com.TicketService.SearchTrains.coupon.validation;

import com.TicketService.SearchTrains.entities.Coupon;

public class ExpiryValidator extends CouponValidator {

    @Override
    public void validate(Coupon coupon, double fare) {
        boolean expired = false; // DB / date logic

        if (expired) {
            throw new RuntimeException("Coupon expired");
        }

        if (next != null) next.validate(coupon, fare);
    }
}
