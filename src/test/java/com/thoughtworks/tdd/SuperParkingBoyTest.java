package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SuperParkingBoyTest {
    @Test
    void should_park_car_in_another_parkingLot_which_size_occupy_capacity_is_max_when_the_first_parking_lot_is_full(){
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(10);
        ParkingLot parkingLot3 = new ParkingLot(2);
        Parker SuperParkingBoy = new SuperParkingBoy(parkingLot1,parkingLot2,parkingLot3);

        SuperParkingBoy.park(new Car());
        SuperParkingBoy.park(new Car());
        SuperParkingBoy.park(new Car());
        SuperParkingBoy.park(new Car());
        SuperParkingBoy.park(new Car());

        Assertions.assertEquals(3,parkingLot2.getCars().size());
    }
}
