package com.thoughtworks.tdd;

import com.thoughtworks.tdd.Exception.ErrorTicketException;
import com.thoughtworks.tdd.Exception.NotEnoughPosition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ParkingBoyTest {

    @Test
    void should_return_null_when_given_a_invalid_ticket_to_fetch_car(){

        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        parkingBoy.park(car1);

        Assertions.assertThrows(NotEnoughPosition.class,() -> parkingBoy.park(new Car()));
    }

    @Test
    void should_throw_ticket_missing_exception_when_given_a_null_ticket_to_fetch_car(){
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot1);
        parkingBoy.park(new Car());

        Assertions.assertThrows(ErrorTicketException.class,() -> parkingBoy.fetch(new ParkTicket()));
    }


    @Test
    void should_park_car_in_another_parkingLot_when_the_previous_parkinglot_is_full(){

        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ParkingLot parkTicket3 = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot1,parkingLot2,parkTicket3);

        parkingBoy.park(new Car());
        parkingBoy.park(new Car());
        parkingBoy.park(new Car());

        Assertions.assertEquals(2,parkingLot2.getCars().size());
    }

}
