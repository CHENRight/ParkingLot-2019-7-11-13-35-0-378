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

    @Test
    void should_park_car_in_another_parkingLot_when_the_previous_parkinglot_is_full(){
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1); parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        //when
        ParkTicket ticketNormal1 = parkingBoy.park(car1);
        ParkTicket ticketNormal2 = parkingBoy.park(car2);
        ParkTicket ticketNull = parkingBoy.park(car3);
        //then
        Assertions.assertNotNull(ticketNormal1);
        Assertions.assertNotNull(ticketNormal2);
        Assertions.assertNull(ticketNull);
    }

}
