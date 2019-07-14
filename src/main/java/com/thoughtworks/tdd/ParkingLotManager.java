package com.thoughtworks.tdd;

import java.util.List;

public class ParkingLotManager implements Parkable {
    private List<ParkingBoy> parkingBoys;
    private List<ParkingLot> privateParkingLots;
    private List<ParkingLot> parkingLots;

    public void dispatchParkingBoy(ParkingBoy parkingBoy,ParkingLot parkingLot){

        if(parkingLots.contains(parkingLot) && parkingBoys.contains(parkingBoy)){
            parkingBoy.getParkingLots().add(parkingLot);

        }

    }



    @Override
    public ParkTicket park(Car car) {
        return null;
    }

    @Override
    public Car fetch(ParkTicket ticket) {
        return null;
    }

    public void AddParkingLot(ParkingLot parkingLot){
        this.parkingLots.add(parkingLot);
        this.privateParkingLots.add(parkingLot);
    }
}
