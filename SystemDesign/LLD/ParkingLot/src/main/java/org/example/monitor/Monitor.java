package org.example.monitor;

import org.example.parkingspots.ParkingSpot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Monitor implements Observer {
    private Map<String, List<ParkingSpot>> map;

    public Monitor(){
        map = new HashMap<String, List<ParkingSpot>>();
    }

    @Override
    public void update(ParkingSpot ps) {
        if(map.get(ps.getClass().getName())==null) {
            map.put(ps.getClass().getName(),new ArrayList<ParkingSpot>());
        }
           List<ParkingSpot> list = map.get(ps.getClass().getName());
           boolean flag = false;
           for(ParkingSpot p : list){
               if(p.getId()==ps.getId()){
                   p = ps;
                   flag = true;
               }
           }
           if(!flag){
               map.get(ps.getClass().getName()).add(ps);
           }
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "map=" + map +
                '}';
    }
}
