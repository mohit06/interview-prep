package org.example.monitor;

public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void notifyAllObservers();
}
