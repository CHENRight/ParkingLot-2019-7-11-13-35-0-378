package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SmartParkingBoyTest {
    @Test
    void should_park_car_in_another_parkingLot_which_has_the_most_positions_when_the_first_parkinglot_is_full(){
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingLot parkingLot3 = new ParkingLot(2);
        Parker smartParkingBoy = new SmartParkingBoy(parkingLot1,parkingLot2,parkingLot3);
        smartParkingBoy.park(new Car());
        smartParkingBoy.park(new Car());
        //then
        Assertions.assertEquals(1,parkingLot3.getCars().size());
    }
}
