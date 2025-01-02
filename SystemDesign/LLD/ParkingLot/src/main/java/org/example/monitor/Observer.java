package org.example.monitor;

import org.example.parkingspots.ParkingSpot;

public interface Observer {
    void update(ParkingSpot ps);
}
