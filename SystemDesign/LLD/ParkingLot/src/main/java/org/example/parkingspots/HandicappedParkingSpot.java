package org.example.parkingspots;

import org.example.monitor.Observer;
import org.example.monitor.Subject;

import java.util.ArrayList;
import java.util.List;

public class HandicappedParkingSpot extends ParkingSpot {

    //List<Observer> observers;
    public HandicappedParkingSpot(long id, boolean isAvailable) {
        super(id, isAvailable);
     //   observers = new ArrayList<Observer>();
    }

//    @Override
//    public void register(Observer o) {
//        observers.add(o);
//    }
//
//    @Override
//    public void unregister(Observer o) {
//        observers.remove(o);
//    }
//
//    @Override
//    public void notifyAllObservers() {
//        for(Observer o : observers){
//            o.update(this);
//        }
//    }
}
