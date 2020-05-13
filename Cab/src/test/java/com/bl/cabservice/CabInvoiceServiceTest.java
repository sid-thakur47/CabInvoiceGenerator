package com.bl.cabservice;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceServiceTest {
    CabInvoiceService cabInvoiceService = new CabInvoiceService();

    @Test
    public void givenDistanceANdTime_ShouldReturnFare() {

        double distance = 2.0;
        int time = 5;
        double fare = cabInvoiceService.calculateFare( distance, time );
        Assert.assertEquals( 25, fare, 0.0 );
    }
    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoiceService.calculateFare( distance, time );
        Assert.assertEquals( 5.0, fare, 0.0 );
    }
    @Test
    public void givenMultipleRides_ShouldReturnFare() {
        Ride[] rides = {
                new Ride( 0.1, 1 ),
                new Ride( 2.0, 5 ),
                new Ride( 3.0, 5 )
        };
        EnhancedInvoice enhancedInvoice = cabInvoiceService.calculateFare( rides );
        EnhancedInvoice invoice = new EnhancedInvoice( 3, 65.0 );
        Assert.assertEquals( invoice, enhancedInvoice );
    }
}