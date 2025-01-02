package org.example;

import org.example.db.DatabaseService;
import org.example.parkingspots.ParkingSpot;
import org.example.terminals.EntranceTerminal;
import org.example.terminals.ExitTerminal;

import java.util.List;
import java.util.Map;

public class ParkingLotBuilder {
    List<EntranceTerminal> entrances;
    List<ExitTerminal> exits;
    Map<String,List<ParkingSpot>> parkingSpots;
    DatabaseService db;

    public ParkingLotBuilder(){
//        this.entrances = entrances;
//        this.exits = exits;
//        this.db = db;
//        this.parkingSpots = parkingSpots;
    }

    public ParkingLot build(){
        return new ParkingLot(this);
    }

    public ParkingLotBuilder setEntrances(List<EntranceTerminal> entrances) {
        this.entrances = entrances;
        return this;
    }

    public ParkingLotBuilder setExits(List<ExitTerminal> exits) {
        this.exits = exits;
        return this;
    }

    public ParkingLotBuilder setParkingSpots(Map<String, List<ParkingSpot>> parkingSpots) {
        this.parkingSpots = parkingSpots;
        return this;
    }

    public ParkingLotBuilder setDb(DatabaseService db) {
        this.db = db;
        return this;
    }
}
