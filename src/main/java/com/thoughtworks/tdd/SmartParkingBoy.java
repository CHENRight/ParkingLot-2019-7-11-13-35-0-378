package com.thoughtworks.tdd;

import com.thoughtworks.tdd.Exception.NotEnoughPosition;

import java.util.Arrays;

public class SmartParkingBoy extends Parker {

    public SmartParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots.addAll(Arrays.asList(parkingLots));
    }


    public ParkTicket park(Car car) {
        if(car == null){ return null;}
        if(isFull()){
            throw new NotEnoughPosition();
        }
        ParkingLot usedParkingLot = new ParkingLot();
        int max = 1;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getCapacity() > parkingLot.getCars().size()) {
                if (parkingLot.getCapacity() - parkingLot.getCars().size() > max) {
                    max = parkingLot.getCapacity() - parkingLot.getCars().size();
                    usedParkingLot = parkingLot;
                }
            }
        }
        ParkTicket ticket = new ParkTicket();
        usedParkingLot.getCars().put(ticket,car);
        return ticket;
    }

}
