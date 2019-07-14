package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<ParkTicket,Car> cars = new HashMap<ParkTicket,Car>();
    private boolean dispatchStatus;

    public ParkingLot() {
        this.capacity = 10;
        this.dispatchStatus = false;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.dispatchStatus = false;
    }

    public ParkTicket park(Car car) {
        if(capacity > cars.size() && car != null){
            ParkTicket ticket = new ParkTicket();
            cars.put(ticket,car);
            return ticket;
        }else {
            return null;
        }
    }

    public Car fetch(ParkTicket ticket) {
        if(cars.containsKey(ticket)){
            return cars.remove(ticket);
        }else {
            return null;
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public Map<ParkTicket, Car> getCars() {
        return cars;
    }

    public boolean getDispatchStatus() {
        return dispatchStatus;
    }

    public void setDispatchStatus(boolean dispatchStatus) {
        this.dispatchStatus = dispatchStatus;
    }
}
