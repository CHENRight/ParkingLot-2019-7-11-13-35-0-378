package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SuperParkingBoyTest {
    @Test
    void should_park_car_in_another_parkingLot_which_size_occupy_capacity_is_max_when_the_first_parking_lot_is_full(){
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(10);
        ParkingLot parkingLot3 = new ParkingLot(2);
        List parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        ParkingBoy SuperParkingBoy = new SuperParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();
        //when
        ParkTicket ticketNormal1 = SuperParkingBoy.park(car1);
        ParkTicket ticketNormal2 = SuperParkingBoy.park(car2);
        ParkTicket ticketNormal3 = SuperParkingBoy.park(car3);
        ParkTicket ticketNormal4 = SuperParkingBoy.park(car4);
        ParkTicket ticketNormal5 = SuperParkingBoy.park(car5);
        //then
        Assertions.assertEquals(3,SuperParkingBoy.parkingLots.get(1).getCars().size());
    }
}
