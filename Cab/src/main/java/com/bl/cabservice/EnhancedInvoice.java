package com.bl.cabservice;

public class EnhancedInvoice {
    int totalRides;
    double totalFare;
    double averageFare;

    public EnhancedInvoice(int totalRides, double totalFare) {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.averageFare = (totalFare / totalRides);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnhancedInvoice that = (EnhancedInvoice) o;
        return totalRides == that.totalRides &&
                Double.compare( that.totalFare, totalFare ) == 0 &&
                Double.compare( that.averageFare, averageFare ) == 0;
    }
}
