package org.example.TicketGenerator;

import org.example.ParkingspotAssignmentStrategies.ParkingSpotStrategy;
import org.example.parkingspots.ParkingSpot;

import java.util.Random;

public class NormalTicketGenerator implements TicketGenerator {
    ParkingSpotStrategy strategy;

    public NormalTicketGenerator(ParkingSpotStrategy strategy){
        this.strategy = strategy;
    }

    @Override
    public Ticket generateTicket(String parkingSpotType) {
        Random random = new Random();
        ParkingSpot parkingSpot = strategy.assignParkingSpot(parkingSpotType);
        Ticket ticket = new Ticket(random.nextLong());
        ticket.setParkingSpot(parkingSpot);
        ticket.setParkingSpotType(parkingSpotType);
        return ticket;
    }
}
