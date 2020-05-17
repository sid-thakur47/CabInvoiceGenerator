package com.bl.cabservice.repository;

import com.bl.cabservice.Ride;

import java.util.*;

public class RideRepository {
    Map<String, List<Ride>> userRide;
    public RideRepository() {
        userRide = new HashMap<>();
    }
    public void addUserRides(String userId, Ride[] rides) {
           this.userRide.put( userId,Arrays.asList( rides ));
    }
    public Ride[] getRide(String userId){
        return  this.userRide.get(userId).toArray(new Ride[0]);
    }
}

