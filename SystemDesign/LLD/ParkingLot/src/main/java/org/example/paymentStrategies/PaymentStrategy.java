package org.example.paymentStrategies;

import org.example.TicketGenerator.Ticket;

public abstract class PaymentStrategy {

    public abstract void pay(Ticket ticket);
}
