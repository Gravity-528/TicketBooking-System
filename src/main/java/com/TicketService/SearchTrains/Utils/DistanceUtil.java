package com.TicketService.SearchTrains.Utils;

public class DistanceUtil {

    public static long travelMinutes(double distanceKm, double speedKmPerHr) {
        return Math.round((distanceKm / speedKmPerHr) * 60);
    }
}

