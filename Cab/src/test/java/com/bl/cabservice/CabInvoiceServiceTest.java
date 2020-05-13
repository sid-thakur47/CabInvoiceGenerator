package com.bl.cabservice;

import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceServiceTest {

    @Test
    public void givenDistanceANdTime_ShouldReturnFare() {
        CabInvoiceService cabInvoiceService = new CabInvoiceService();
        double distance = 2.0;
        int time = 5;
        double fare = cabInvoiceService.calculateFare( distance, time );
        Assert.assertEquals( 25, fare, 0.0 );
    }
    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinimumFare() {
        CabInvoiceService cabInvoiceService = new CabInvoiceService();
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoiceService.calculateFare( distance, time );
        Assert.assertEquals( 5.0, fare, 0.0 );
    }
    @Test
    public void givenMultipleRides_ShouldReturnFare() {
        CabInvoiceService cabInvoiceService = new CabInvoiceService();
        Ride[] rides ={
                new Ride( 2.0, 5 ),
                new Ride(3.0,5),
                new Ride(4.0,5)
        };
        double fare =cabInvoiceService.calculateFare(rides);
        Assert.assertEquals( 105.0, fare, 0.0 );
    }
}

