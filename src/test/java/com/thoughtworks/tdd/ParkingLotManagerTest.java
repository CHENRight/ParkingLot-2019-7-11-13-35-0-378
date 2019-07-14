package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManagerTest {

    @Test
    void should_park_car_in_another_parkingLot_which_has_the_most_positions_when_the_first_parkinglot_is_full(){
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingLot parkingLot3 = new ParkingLot(2);
        List parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        ParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        //when
        ParkTicket ticketNormal1 = smartParkingBoy.park(car1);
        ParkTicket ticketNormal2 = smartParkingBoy.park(car2);
        //then
        Assertions.assertEquals(1,smartParkingBoy.parkingLots.get(2).getCars().size());
    }

}
