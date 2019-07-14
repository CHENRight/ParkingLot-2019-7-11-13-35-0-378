package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoyTest {

    @Test
    void should_return_null_when_given_a_invalid_ticket_to_fetch_car(){
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        Car car1 = new Car();
        Car car2 = new Car();
        //when
        ParkTicket ticketNormal = parkingBoy.park(car1);
        ParkTicket ticket2 = parkingBoy.park(car2);
        Car fetchCarSuccess = parkingBoy.fetch(ticketNormal);
        Car fetchCarWithNull = parkingBoy.fetch(null);
        Car fetchCarWithInvalidTicket = parkingBoy.fetch(ticketNormal);
        //then
        Assertions.assertEquals(car1,fetchCarSuccess);
        Assertions.assertNull(fetchCarWithNull);
        Assertions.assertNull(fetchCarWithInvalidTicket);
    }

}
