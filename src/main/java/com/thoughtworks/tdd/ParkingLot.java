package com.thoughtworks.tdd;

import com.thoughtworks.tdd.Exception.NotEnoughPosition;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements Parkable{
    private final int capacity;
    private Map<ParkTicket,Car> cars = new HashMap<ParkTicket,Car>();

    public ParkingLot() {
        this.capacity = 10;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkTicket park(Car car) {
        if(isFull()){
            throw new NotEnoughPosition();
        }
        if(car == null){return null;}

        ParkTicket ticket = new ParkTicket();
        cars.put(ticket,car);
        return ticket;

    }

    public Car fetch(ParkTicket ticket) {
        return cars.remove(ticket);
    }

    @Override
    public boolean contains(ParkTicket ticket) {
        return cars.containsKey(ticket);
    }

    public boolean isFull(){
        return capacity <= cars.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public Map<ParkTicket, Car> getCars() {
        return cars;
    }

}

