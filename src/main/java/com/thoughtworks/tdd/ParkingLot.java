package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<ParkTicket,Car> cars = new HashMap<ParkTicket,Car>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkTicket park(Car car) {
        if(capacity > cars.size() || car != null){
            ParkTicket ticket = new ParkTicket();
            cars.put(ticket,car);
            return ticket;
        }else {
            return null;
        }
    }

    public Car fetch(ParkTicket ticket) {
        return cars.remove(ticket);
    }
}
