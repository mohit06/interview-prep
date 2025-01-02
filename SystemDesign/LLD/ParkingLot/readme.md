Requirements:

Big Parking Lot : 30000 vehicles can be parked.
Multiple(4) Entrances/Exits should be supported.
Tickets can be collected at Entrances and spot is assigned at entrance on ticket.
ParkingSpot assigned should be near to entrance.
System should not allow more vehicles than capacity.
There are 4 types of ParkingSpots: Handicapped, Large, Compact, Motorcycles
Final payment amount is calculated based on hourly rate.
Payment can be done at any exit using card or cash.
There should be monitoring of spots. How many spots are there in total? How many spots are busy ? How many spots are available? 
These queries should be answered.

Actors:
ParkingSpot, Entrance, Exit, Ticket, ParkingLot, Monitor, Payment.

Different designe patterns that can be implemented:
1. Strategy Pattern : For creating multiple types of payment methods, different types of parking spots etc, we can create a interface and 
implement the individual strategies in their individual implementation.
2. Builder Pattern: We can create a ParkingLotBuilder to create ParkingLot Objects. We can also create TicketBuilder to create Ticket objects.
3. Observer Pattern: Monitor will be observer and ParkingSpots will be subject/publisher. Whenever there is any state change of any spot,
that spot will publish this event to all the registered observers.
4. Factory Method Pattern: Client can create different types of ParkingLots. Instead, we can provide a factory method which would return the 
requested type of object.
