package com.thoughtworks.tdd;

import com.thoughtworks.tdd.Exception.NotEnoughPosition;

import java.util.Arrays;

public class SuperParkingBoy extends Parker {

    public SuperParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots.addAll(Arrays.asList(parkingLots));
    }

    @Override
    public ParkTicket park(Car car) {
        if(car == null){
            return null;
        }
        if(isFull()){
            throw new NotEnoughPosition();
        }
        ParkingLot usedParkingLot = new ParkingLot();
        double max = Double.MIN_VALUE;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getCapacity() > parkingLot.getCars().size() && availablePositionRate(parkingLot) > max) {
                max = parkingLot.getCars().size() / (double) parkingLot.getCapacity();
                usedParkingLot = parkingLot;
            }
        }
        ParkTicket ticket = new ParkTicket();
        usedParkingLot.getCars().put(ticket,car);
        return ticket;
    }

    public double availablePositionRate(ParkingLot parkingLot){
        return parkingLot.getCapacity() - parkingLot.getCars().size() / (double)parkingLot.getCapacity();
    }
}
