package com.thoughtworks.tdd;

import com.thoughtworks.tdd.Exception.ErrorTicketException;
import com.thoughtworks.tdd.Exception.NotEnoughPosition;
import com.thoughtworks.tdd.Exception.TicketMissingExcception;

import java.util.*;

public class ParkingLotManager {
    private List<Parkable> parkers = new ArrayList<>();

    public ParkingLotManager(Parkable... parkables) {
        this.parkers.addAll(Arrays.asList(parkables));
    }

    public ParkTicket park(Car car){
        for (int i = 0; i < parkers.size(); i++) {
            if(!parkers.get(i).isFull()){
                return parkers.get(i).park(car);
            }
        }
        throw new NotEnoughPosition();
    }

    public Car fetch(ParkTicket ticket){
        if(ticket == null){
            throw new TicketMissingExcception();
        }
        for (int i = 0; i < parkers.size(); i++) {
            Parkable parkable = parkers.get(i);
            if (parkable.contains(ticket)) {
                return parkable.fetch(ticket);
            }
        }
        throw new ErrorTicketException();
    }

}

