package org.example.TicketGenerator;

import org.example.parkingspots.ParkingSpot;

import java.time.LocalDateTime;

public class Ticket {
    private long id;
    private LocalDateTime entryTime;
    private ParkingSpot parkingSpot;
    private String parkingSpotType;

    public Ticket(long id) {
        this.id = id;
        entryTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", entryTime=" + entryTime +
                ", parkingSpot=" + parkingSpot +
                ", parkingSpotType='" + parkingSpotType + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot spot) {
        this.parkingSpot = spot;
    }

    public String getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(String parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }
}
