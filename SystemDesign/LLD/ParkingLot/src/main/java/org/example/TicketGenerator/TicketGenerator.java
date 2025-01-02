package org.example.TicketGenerator;

import org.example.ParkingLot;

public interface TicketGenerator {
    Ticket generateTicket(String parkingSpotType);
}
