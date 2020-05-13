package com.bl.cabservice;

public class CabInvoiceService implements Constant {

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
        return Math.max( totalFare, MINIMUM_FARE );
    }
    public EnhancedInvoice calculateFare(Ride[] rides){
        double totalFare= 0;
        for(Ride ride: rides){
            totalFare+=  this.calculateFare( ride.distance,ride.time );
        }
        return new EnhancedInvoice(rides.length,totalFare);
    }
}
