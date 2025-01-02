package org.example.ParkingspotAssignmentStrategies;

import org.example.ParkingLot;
import org.example.parkingspots.CompactVehicleParkingSpot;
import org.example.parkingspots.ParkingSpot;

public abstract class ParkingSpotStrategy {
    public abstract ParkingSpot assignParkingSpot(String parkingSpotType);

    public void releaseSpot(ParkingSpot spot){
        spot.setAvailable(true);
        spot.notifyAllObservers();
    }
}
