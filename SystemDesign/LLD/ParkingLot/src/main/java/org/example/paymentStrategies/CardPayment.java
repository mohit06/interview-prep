package org.example.paymentStrategies;

import org.example.AmountCalculator.AbstractAmountCalculator;
import org.example.TicketGenerator.Ticket;

public class CardPayment extends PaymentStrategy{
    private AbstractAmountCalculator calc;

    public CardPayment(AbstractAmountCalculator calc){
        this.calc = calc;
    }

    @Override
    public void pay(Ticket ticket) {
       double amt= calc.calculateAmount(ticket);
        System.out.println("Total Amt to pay : "+amt);
        ticket.getParkingSpot().setAvailable(true);

        System.out.println("Spot "+ticket.getParkingSpot() + " is available now.");
    }
}
