package com.TicketService.SearchTrains.coupon.validation;

import com.TicketService.SearchTrains.entities.Coupon;

public abstract class CouponValidator {

    protected CouponValidator next;

    public void setNext(CouponValidator next) {
        this.next = next;
    }

    public abstract void validate(Coupon coupon, double fare);
}
