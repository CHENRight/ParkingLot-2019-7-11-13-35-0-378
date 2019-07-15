package com.thoughtworks.tdd;

import com.thoughtworks.tdd.Exception.NotEnoughPosition;

import java.util.Arrays;

public class ParkingBoy extends Parker{

    public ParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots.addAll(Arrays.asList(parkingLots));
    }

    @Override
    public ParkTicket park(Car car) {
        if(car == null){return null;}
        if(isFull()){
            throw new NotEnoughPosition();
        }
        ParkingLot usedParkingLot = new ParkingLot();
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getCapacity() > parkingLot.getCars().size()) {
                usedParkingLot = parkingLot;
                break;
            }
        }
        ParkTicket ticket = new ParkTicket();
        usedParkingLot.getCars().put(ticket,car);
        return ticket;
    }
}
