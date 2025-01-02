package org.example.terminals;

import org.example.TicketGenerator.Ticket;
import org.example.TicketGenerator.TicketGenerator;

public class EntranceTerminal {
    private long id;
    private TicketGenerator ticketGenerator;

    public EntranceTerminal(long id, TicketGenerator ticketGenerator){
        id = this.id;
        this.ticketGenerator = ticketGenerator;
    }

    public Ticket getTicket(String parkingSpotType){
        Ticket ticket = ticketGenerator.generateTicket(parkingSpotType);
        System.out.println("Generated Ticket at entrance : "+id);
        System.out.println(ticket.toString());
        return ticket;
    }
}
