package com.bl.cabservice.service;

import com.bl.cabservice.EnhancedInvoice;
import com.bl.cabservice.Ride;
import com.bl.cabservice.constant.Constant;
import com.bl.cabservice.repository.RideRepository;

public class CabInvoiceService implements Constant {
    RideRepository rideRepository;

    public CabInvoiceService() {
        this.rideRepository = new RideRepository();
    }

    public double calculateFare(double distance, int time, String cabType) {
        if (cabType.equals( NORMAL )) {
            double totalFare = distance * NORMAL_MINIMUM_COST_PER_KM + time * NORMAl_COST_PER_TIME;
            return Math.max( totalFare, NORMAL_MINIMUM_FARE );
        } else if (cabType.equals( PREMIUM )) {
            double totalFare = distance * PREMIUM_MINIMUM_COST_PER_KM + time * PREMIUM_COST_PER_TIME;
            return Math.max( totalFare, PREMIUM_MINIMUM_FARE );
        }
        return 0;
    }

    public EnhancedInvoice calculateFare(Ride[] rides, String cabType) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare( ride.distance, ride.time, cabType );
        }
        return new EnhancedInvoice( rides.length, totalFare );
    }

    public void addRidesToRepository(String userId, Ride[] rides) {
        rideRepository.addUserRides( userId, rides );
    }

    public EnhancedInvoice getInVoiceSummary(String userId, String cabType) {
        return this.calculateFare( rideRepository.getRide( userId ), cabType );
    }
}
