package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotManager implements Parkable {
    private List<ParkingBoy> parkingBoys = new ArrayList<>();
    private List<ParkingLot> privateParkingLots = new ArrayList<>();
    private Map<ParkTicket,ParkingBoy> manageParkLotCars = new HashMap<>();

    public ParkingLotManager() {}

    public ParkingLotManager(List<ParkingBoy> parkingBoys, List<ParkingLot> privateParkingLots) {
        this.parkingBoys = parkingBoys;
        this.privateParkingLots = privateParkingLots;
    }
    //private List<ParkingLot> parkingLots;

    public void dispatchParkingBoy(ParkingBoy parkingBoy,ParkingLot parkingLot){
        if(parkingBoy == null){
            System.out.println("Can not manage a empty parking boy.");
            return;
        }
        if(!parkingBoys.contains(parkingBoy)){
            return;
        }
        parkingBoy.getParkingLots().add(parkingLot);
        parkingLot.setDispatchStatus(true);
        parkingBoys.remove(parkingBoy);
    }



    @Override
    public ParkTicket park(Car car) {
        if(car == null){ return null; }
        if(isAllParkingLotFull(privateParkingLots)){
            System.out.println("the manager's parking lots are full.");
            return null;
        }

        ParkingLot usedParkingLot = new ParkingLot();
        double max = Double.MIN_VALUE;
        for (int i = 0; i < privateParkingLots.size(); i++) {
            int availablePosition = privateParkingLots.get(i).getCapacity() - privateParkingLots.get(i).getCars().size();
            if(availablePosition-1 / (double)privateParkingLots.get(i).getCapacity() > max){
                max = availablePosition-1 / (double)privateParkingLots.get(i).getCapacity();
                usedParkingLot = privateParkingLots.get(i);
            }
        }
        ParkTicket ticket = new ParkTicket();
        usedParkingLot.getCars().put(ticket,car);
        return ticket;
    }

    public ParkTicket park(Car car,ParkingBoy parkingBoy,ParkingLot parkingLot) {
        if(car == null){ return null; }
        if(!parkingBoys.contains(parkingBoy)){
            System.out.println("This manager has already managed the parking boy.");
        }
        if(!privateParkingLots.contains(parkingLot)){
            System.out.println("This manager didn't manage this parkingLot.");
        }
        dispatchParkingBoy(parkingBoy,parkingLot);
        return parkingBoy.park(car);
    }

    public ParkTicket park(Car car,ParkingBoy parkingBoy) {
        if(car == null){ return null; }
        if(!parkingBoys.contains(parkingBoy)){
            System.out.println("This manager has already managed the parking boy.");
        }
        return parkingBoy.park(car);
    }

    @Override
    public Car fetch(ParkTicket ticket) {
        if (ticket == null) {
            System.out.print("Please provide your parking ticket.");
            return null;
        }
        ParkingBoy parkingBoy =manageParkLotCars.get(ticket);
        if (parkingBoy == null) {
            System.out.print("Unrecognized parking ticket.");
            return null;
        }
        return parkingBoy.fetch(ticket);
    }

    public void AddParkingLot(ParkingLot parkingLot){
        this.privateParkingLots.add(parkingLot);
    }

    public void AddParkingBoy(ParkingBoy parkingBoy){
        this.parkingBoys.add(parkingBoy);
    }


    public boolean isAllParkingLotFull(List<ParkingLot> privateParkingLots){
        for (int i = 0; i < privateParkingLots.size(); i++) {
            if(privateParkingLots.get(i).getCapacity() > privateParkingLots.get(i).getCars().size()){
                return false;
            }
        }
        return true;
    }


    //getter and setter
    public List<ParkingBoy> getParkingBoys() {
        return parkingBoys;
    }

    public void setParkingBoys(List<ParkingBoy> parkingBoys) {
        this.parkingBoys = parkingBoys;
    }
}
