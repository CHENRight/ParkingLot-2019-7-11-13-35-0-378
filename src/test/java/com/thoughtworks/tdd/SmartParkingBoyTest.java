package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoyTest {
    @Test
    void should_park_car_in_another_parkingLot_when_the_previous_parkinglot_is_full(){
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingLot parkingLot3 = new ParkingLot(2);
        List parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        //when
        ParkTicket ticketNormal1 = parkingBoy.park(car1);
        ParkTicket ticketNormal2 = parkingBoy.park(car2);
        //then
        Assertions.assertEquals(1,parkingBoy.parkingLots.get(1).getCars().size());
    }
}
