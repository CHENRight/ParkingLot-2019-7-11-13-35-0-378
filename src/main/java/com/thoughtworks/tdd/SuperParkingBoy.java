package com.thoughtworks.tdd;

import java.util.List;

public class SuperParkingBoy extends ParkingBoy {
    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkTicket park(Car car) {
        if(car == null){
            return null;
        }
        if(isAllParkingLotFull(parkingLots)){
            System.out.println("Not enough position.");
            return null;
        }
        ParkingLot usedParkingLot = new ParkingLot();
        double max = Double.MIN_VALUE;
        for (int i = 0; i < parkingLots.size(); i++) {
            int availablePosition = parkingLots.get(i).getCapacity() - parkingLots.get(i).getCars().size();
            if(availablePosition > 0){
                if(availablePosition / (double)parkingLots.get(i).getCapacity() > max){
                    max = parkingLots.get(i).getCars().size() / (double)parkingLots.get(i).getCapacity();
                    usedParkingLot = parkingLots.get(i);
                }
            }
        }
        ParkTicket ticket = new ParkTicket();
        usedParkingLot.getCars().put(ticket,car);
        return ticket;
    }
}
