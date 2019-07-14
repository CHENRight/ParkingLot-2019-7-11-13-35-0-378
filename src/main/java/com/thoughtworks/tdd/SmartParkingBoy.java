package com.thoughtworks.tdd;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(){}
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
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
        int max = 1;
        for (int i = 0; i < parkingLots.size(); i++) {
            if(parkingLots.get(i).getCapacity() > parkingLots.get(i).getCars().size()){
                if(parkingLots.get(i).getCapacity() - parkingLots.get(i).getCars().size() > max){
                    max = parkingLots.get(i).getCapacity() - parkingLots.get(i).getCars().size();
                    usedParkingLot = parkingLots.get(i);
                }
            }
        }
        ParkTicket ticket = new ParkTicket();
        usedParkingLot.getCars().put(ticket,car);
        return ticket;
    }
}
