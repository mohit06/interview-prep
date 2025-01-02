package org.example.terminals;

import org.example.TicketGenerator.Ticket;
import org.example.paymentStrategies.PaymentStrategy;

public class ExitTerminal {
    private long id;
    PaymentStrategy paymentStrategy;


    public ExitTerminal(long id, PaymentStrategy paymentStrategy){
        this.id = id;
        this.paymentStrategy = paymentStrategy;

    }

    public void startTicketPayment(Ticket ticket){
        paymentStrategy.pay(ticket);
    }
}
