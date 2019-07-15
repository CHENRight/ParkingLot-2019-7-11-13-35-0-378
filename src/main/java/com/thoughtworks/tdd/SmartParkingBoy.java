package com.thoughtworks.tdd;

import com.thoughtworks.tdd.Exception.NotEnoughPosition;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SmartParkingBoy extends Parker {

    public SmartParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots.addAll(Arrays.asList(parkingLots));
    }

    public ParkTicket park(Car car) {
        if (car == null) {
            return null;
        }
        ParkingLot moreEmptyParkingLot = null;
        try{
            moreEmptyParkingLot = parkingLots.stream().filter(parkingLot -> !parkingLot.isFull()).sorted((parkingLot1,parkingLot2) -> parkingLot2.countVvaidPosition() - parkingLot1.countVvaidPosition()).findFirst().get();
        }catch (Exception e){
            throw new NotEnoughPosition();
        }
        return moreEmptyParkingLot.park(car);

    }
    

    @Override
    public boolean isFull(){
        for (int i = 0; i < parkingLots.size(); i++) {
            if(parkingLots.get(i).getCapacity() > parkingLots.get(i).getCars().size()){
                return false;
            }
        }
        return true;
    }

}
