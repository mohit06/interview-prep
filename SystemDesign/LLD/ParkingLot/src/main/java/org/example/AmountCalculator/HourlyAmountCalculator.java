package org.example.AmountCalculator;

import org.example.TicketGenerator.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyAmountCalculator extends AbstractAmountCalculator {
    private double rate;
    public HourlyAmountCalculator(double r){
        rate=r;
    }

    @Override
    public double calculateAmount(Ticket ticket) {
        return rate * Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toSeconds();
    }
}
