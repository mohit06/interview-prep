package org.example;

import org.example.AmountCalculator.HourlyAmountCalculator;
import org.example.ParkingspotAssignmentStrategies.FCFSParkingStrategy;
import org.example.TicketGenerator.NormalTicketGenerator;
import org.example.TicketGenerator.Ticket;
import org.example.TicketGenerator.TicketGenerator;
import org.example.db.DatabaseService;
import org.example.monitor.Monitor;
import org.example.parkingspots.HandicappedParkingSpot;
import org.example.parkingspots.LargeVehicleParkingSpot;
import org.example.parkingspots.ParkingSpot;
import org.example.paymentStrategies.CardPayment;
import org.example.paymentStrategies.PaymentStrategy;
import org.example.terminals.EntranceTerminal;
import org.example.terminals.ExitTerminal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        DatabaseService db = new DatabaseService();

        TicketGenerator tg = new NormalTicketGenerator(new FCFSParkingStrategy(db));
        PaymentStrategy ps = new CardPayment(new HourlyAmountCalculator(50));

        EntranceTerminal entrance1 = new EntranceTerminal(1, tg);
        EntranceTerminal entrance2 = new EntranceTerminal(2, tg);
        EntranceTerminal entrance3 = new EntranceTerminal(3, tg);

        ExitTerminal exit1 = new ExitTerminal(1, ps);
        ExitTerminal exit2 = new ExitTerminal(2, ps);
        ExitTerminal exit3 = new ExitTerminal(3, ps);

        List<EntranceTerminal> entranceList = List.of(entrance1,entrance2,entrance3);
        List<ExitTerminal> exitTerminalList = List.of(exit1,exit2,exit3);

        Monitor monitor = new Monitor();

        HandicappedParkingSpot hc1 = new HandicappedParkingSpot(1,true);
        hc1.register(monitor);
        HandicappedParkingSpot hc2 = new HandicappedParkingSpot(2,true);
        hc2.register(monitor);

        LargeVehicleParkingSpot lv1 =new LargeVehicleParkingSpot(1,true);
        lv1.register(monitor);
        LargeVehicleParkingSpot lv2 =new LargeVehicleParkingSpot(2,true);
        lv2.register(monitor);

        Map<String, List<ParkingSpot>> map = new HashMap<String, List<ParkingSpot>>();
        map.put("handicapped", List.of(hc1,hc2));
        map.put("large", List.of(lv1,lv2));

        System.out.println(monitor.toString());


        ParkingLot parkingLot = new ParkingLotBuilder()
                .setDb(db)
                .setEntrances(entranceList)
                .setExits(exitTerminalList)
                .setParkingSpots(map)
                .build();

        EntranceTerminal entrance =  parkingLot.getEntrances().get(0);
        ExitTerminal exit = parkingLot.getExits().get(0);
        Ticket ticket = entrance.getTicket("large");
        System.out.println(monitor.toString());
        Thread.sleep(4000);
        Ticket ticket2 = entrance.getTicket("large");
        System.out.println(monitor.toString());
        Thread.sleep(3000);
        exit.startTicketPayment(ticket2);
        System.out.println(monitor.toString());
        exit.startTicketPayment(ticket);
        System.out.println(monitor.toString());

    }
}