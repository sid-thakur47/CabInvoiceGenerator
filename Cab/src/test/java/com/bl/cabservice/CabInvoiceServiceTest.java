package com.bl.cabservice;

import com.bl.cabservice.constant.Constant;
import com.bl.cabservice.service.CabInvoiceService;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceServiceTest implements Constant {
    CabInvoiceService cabInvoiceService = new CabInvoiceService();

    @Test
    public void givenDistanceAndTimeFor_NormalCab_WhenProper_ShouldReturnFare() {
        double distance = 2.0;
        int time = 5;
        double fare = cabInvoiceService.calculateFare( distance, time,NORMAL );
        Assert.assertEquals( 25, fare, 0.0 );
    }
    @Test
    public void givenLessDistanceOrTimeForNormalCab_WhenProper_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoiceService.calculateFare( distance, time ,NORMAL);
        Assert.assertEquals( 5.0, fare, 0.0 );
    }
    @Test
    public void givenMultipleRidesFor_NormalCab_WhenProper_ShouldReturnInvoice() {
        Ride[] rides = {
                new Ride( 0.1, 1 ),
                new Ride( 2.0, 5 ),
                new Ride( 3.0, 5 )
        };
        EnhancedInvoice enhancedInvoice = cabInvoiceService.calculateFare( rides,NORMAL );
        EnhancedInvoice invoice = new EnhancedInvoice( 3, 65.0 );
        Assert.assertEquals( invoice, enhancedInvoice );
    }

    @Test
    public void givenMultipleRidesWithUserId_ForNormalCab_WhenProper_ShouldReturnInvoice() {
        String userId="sid";
        Ride[] rides = {
                new Ride( 0.1, 1 ),
                new Ride( 2.0, 5 ),
                new Ride( 3.0, 5 )
        };
        cabInvoiceService.addRidesToRepository( userId,rides );
        EnhancedInvoice enhancedInvoice = cabInvoiceService.getInVoiceSummary( userId ,NORMAL);
        EnhancedInvoice invoice = new EnhancedInvoice( 3, 65.0);
        Assert.assertEquals( invoice, enhancedInvoice );
    }

    @Test
    public void givenDistanceAndTime_ForPremiumCab_WhenProper_ShouldReturnInvoice() {

        double distance = 2.0;
        int time = 5;
        double fare = cabInvoiceService.calculateFare( distance, time,PREMIUM);
        Assert.assertEquals( 40, fare, 0.0 );
    }

    @Test
    public void givenLessDistanceAndTime_ForPremiumCab_WhenProper_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoiceService.calculateFare( distance, time ,PREMIUM);
        Assert.assertEquals( 20, fare, 0.0 );
    }
    @Test
    public void givenMultipleRidesOf_PremiumCab_WhenProper_ShouldReturnInvoice() {
        Ride[] rides = {
                new Ride( 0.1, 1 ),
                new Ride( 2.0, 5 ),
                new Ride( 3.0, 5 )
        };
        EnhancedInvoice enhancedInvoice = cabInvoiceService.calculateFare( rides,PREMIUM);
        EnhancedInvoice invoice = new EnhancedInvoice( 3, 115.0 );
        Assert.assertEquals( invoice, enhancedInvoice );
    }
    @Test
    public void givenMultipleRidesWithUserId_ForPremiumCab_WhenProper_ShouldReturnInvoice() {
        String userId="123";
        Ride[] rides = {
                new Ride( 0.1, 1 ),
                new Ride( 2.0, 5 ),
                new Ride( 3.0, 5 )
        };
        cabInvoiceService.addRidesToRepository( userId,rides);
        EnhancedInvoice enhancedInvoice = cabInvoiceService.getInVoiceSummary( userId,PREMIUM);
        EnhancedInvoice invoice = new EnhancedInvoice( 3, 115.0 );
        Assert.assertEquals( invoice, enhancedInvoice );
    }
}