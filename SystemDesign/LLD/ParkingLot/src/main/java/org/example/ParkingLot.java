package org.example;


import org.example.db.DatabaseService;
import org.example.parkingspots.ParkingSpot;
import org.example.terminals.EntranceTerminal;
import org.example.terminals.ExitTerminal;

import java.util.List;
import java.util.Map;

public class ParkingLot {
    List<EntranceTerminal> entrances;
    List<ExitTerminal> exits;
    Map<String,List<ParkingSpot>> parkingSpots;
    DatabaseService db;

    public ParkingLot(ParkingLotBuilder builder) {
        this.entrances = builder.entrances;
        this.exits = builder.exits;
        this.parkingSpots = builder.parkingSpots;
        this.db = builder.db;
        db.setEntrances(entrances);
        db.setExits(exits);
        db.setParkingSpots(parkingSpots);
    }

    public List<EntranceTerminal> getEntrances() {
        return entrances;
    }

    public void setEntrances(List<EntranceTerminal> entrances) {
        this.entrances = entrances;
    }

    public List<ExitTerminal> getExits() {
        return exits;
    }

    public void setExits(List<ExitTerminal> exits) {
        this.exits = exits;
    }

    public Map<String, List<ParkingSpot>> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(Map<String, List<ParkingSpot>> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "entrances=" + entrances +
                ", exits=" + exits +
                ", parkingSpots=" + parkingSpots +
                '}';
    }
}
