package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {

    @Test
    void should_parking_and_fetch_car_when_parkinglot_is_exist_and_has_capacity(){
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        //when
        ParkTicket ticket = parkingLot.park(car);
        Car fetchCar = parkingLot.fetch(ticket);
        //then
        Assertions.assertNotNull(ticket);
        Assertions.assertEquals(car,fetchCar);
    }

    @Test
    void should_parking_multiple_cars_and_return_the_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        Car car1 = new Car();
        Car car2 = new Car();
        //when
        ParkTicket ticket1 = parkingLot.park(car1);
        ParkTicket ticket2 = parkingLot.park(car2);
        Car fetchCar1 = parkingLot.fetch(ticket1);
        Car fetchCar2 = parkingLot.fetch(ticket2);
        //then
        Assertions.assertNotNull(ticket1);
        Assertions.assertNotNull(ticket2);
        Assertions.assertEquals(car1,fetchCar1);
        Assertions.assertEquals(car2,fetchCar2);
    }
}
