package com.bl.cabservice;

public class CabInvoiceService implements Constant {
    RideRepository rideRepository;

    public CabInvoiceService() {
        this.rideRepository = new RideRepository();
    }

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
        return Math.max( totalFare, MINIMUM_FARE );
    }

    public EnhancedInvoice calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare( ride.distance, ride.time );
        }
        return new EnhancedInvoice( rides.length, totalFare );
    }

    public void addRidesToRepository(String userId, Ride[] rides) {
        rideRepository.addUserRides( userId, rides );
    }

    public EnhancedInvoice getInVoiceSummary(String userId) {
        return this.calculateFare( rideRepository.getRide( userId ) );
    }
}
