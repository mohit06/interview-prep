package org.example.ParkingspotAssignmentStrategies;

import org.example.ParkingLot;
import org.example.db.DatabaseService;
import org.example.parkingspots.ParkingSpot;

import java.util.List;

public class FCFSParkingStrategy extends ParkingSpotStrategy{
    DatabaseService db;

    public FCFSParkingStrategy(DatabaseService db){
        this.db = db;
    }
    @Override
    public ParkingSpot assignParkingSpot(String parkingSpotType) {
         ParkingSpot ps = db.getParkingSpots().get(parkingSpotType).stream().filter(e -> e.isAvailable()).findFirst().get();
         List<ParkingSpot> list = db.getParkingSpots().get(parkingSpotType);
         for(ParkingSpot p : list){
             if(p.equals(ps)){
                 p.setAvailable(false);
                 p.notifyAllObservers();
             }
         }
         return ps;
    }
}
