package com.thoughtworks.tdd;

import com.thoughtworks.tdd.Exception.ErrorTicketException;
import com.thoughtworks.tdd.Exception.TicketMissingExcception;

import java.util.ArrayList;
import java.util.List;

public abstract class Parker implements Parkable{
    protected List<ParkingLot> parkingLots = new ArrayList<>();

    public abstract ParkTicket park(Car car);

    public Car fetch(ParkTicket ticket) {
        if (ticket == null) {
            throw new TicketMissingExcception();
        }
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.contains(ticket)) {
                return parkingLot.fetch(ticket);
            }
        }
        throw new ErrorTicketException();
    }

    @Override
    public boolean isFull() {
        for (int i = 0; i < parkingLots.size() ; i++) {
            if(parkingLots.get(i).getCapacity() > parkingLots.get(i).getCars().size()){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(ParkTicket ticket) {
        return parkingLots.stream().anyMatch(parkingLot -> parkingLot.contains(ticket));
    }
}

