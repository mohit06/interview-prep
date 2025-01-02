package org.example.parkingspots;

import org.example.monitor.Observer;
import org.example.monitor.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class ParkingSpot  implements Subject{
    private long id;
    private boolean isAvailable;

    List<Observer> observers;

    public ParkingSpot(long id, boolean isAvailable) {
        this.id = id;
        this.isAvailable = isAvailable;
        observers = new ArrayList<Observer>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingSpot that)) return false;
        return id == that.id && isAvailable == that.isAvailable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isAvailable);
    }



    @Override
    public void register(Observer o) {
        observers.add(o);
        notifyAllObservers();
    }

    @Override
    public void unregister(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyAllObservers() {
        for(Observer o : observers){
            o.update(this);
        }
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "id=" + id +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
