package com.thoughtworks.tdd;

import com.thoughtworks.tdd.Exception.ErrorTicketException;
import com.thoughtworks.tdd.Exception.NotEnoughPosition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotManagerTest {

    @Test
    void should_park_car_in_parkingLot_when_given_manage_with_multiple_parkinglot_boys(){

        Parker parkingBoy = new ParkingBoy(new ParkingLot(1));
        Parker smartParkingBoy = new SmartParkingBoy(new ParkingLot(1));
        Parker superParkingBoy = new SuperParkingBoy(new ParkingLot(1));

        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingBoy,smartParkingBoy,superParkingBoy);

        Car car1 = new Car();
        ParkTicket ticket1 = parkingLotManager.park(car1);
        Car fetchedCar = parkingLotManager.fetch(ticket1);

        Assertions.assertEquals(car1,fetchedCar);

    }

    @Test
    void should_throw_Not_enough_position_when_given_manage_with_full_parking_lot(){

        Parker parkingBoy = new ParkingBoy(new ParkingLot(1));
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingBoy);
        parkingLotManager.park(new Car());

        Assertions.assertThrows(NotEnoughPosition.class,() -> parkingLotManager.park(new Car()));
    }

    @Test
    void should_throw_Error_Ticket_when_manage_fetch_with_invalid_park_ticket(){
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingBoy);
        parkingLotManager.park(new Car());

        Assertions.assertThrows(ErrorTicketException.class,() -> parkingLotManager.fetch(new ParkTicket()));
    }

}
