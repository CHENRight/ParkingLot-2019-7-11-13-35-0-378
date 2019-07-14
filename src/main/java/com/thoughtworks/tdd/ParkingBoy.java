package com.thoughtworks.tdd;

import java.util.List;

public class ParkingBoy implements Parkable{

    List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
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
        for (int i = 0; i < parkingLots.size(); i++) {
            if(parkingLots.get(i).getCapacity() > parkingLots.get(i).getCars().size()){
                usedParkingLot = parkingLots.get(i);
                break;
            }
        }
        ParkTicket ticket = new ParkTicket();
        usedParkingLot.getCars().put(ticket,car);
        return ticket;
    }

    @Override
    public Car fetch(ParkTicket ticket) {
        if(ticket == null){
            System.out.println("Please provide your parking ticket.");
            return null;
        }

        if(!isValidTicket(parkingLots,ticket)){
            System.out.println("Unrecognized parking ticket.");
            return null;
        }

        for (int i = 0; i < parkingLots.size(); i++) {
            if(parkingLots.get(i).getCars().containsKey(ticket)){
                return parkingLots.get(i).getCars().remove(ticket);
            }
        }
        return null;
    }

    public boolean isValidTicket(List<ParkingLot> parkingLots,ParkTicket ticket){
        boolean isTicketMapToACar = false;
        for (int i = 0; i < parkingLots.size(); i++) {
            if(parkingLots.get(i).getCars().containsKey(ticket)){
                isTicketMapToACar = true;
            }
        }
        return isTicketMapToACar;
    }

    public boolean isAllParkingLotFull(List<ParkingLot> parkingLots){
        for (int i = 0; i < parkingLots.size(); i++) {
            if(parkingLots.get(i).getCapacity() > parkingLots.get(i).getCars().size()){
                return false;
            }
        }
        return true;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

}
