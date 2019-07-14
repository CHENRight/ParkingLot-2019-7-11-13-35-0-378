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
        ParkingLot parkingLot4 = new ParkingLot(2);
        List parkingLots = new ArrayList<ParkingLot>();
        ParkingBoy parkingBoy1 = new ParkingBoy();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        SuperParkingBoy superParkingBoy = new SuperParkingBoy();
        List parkingBoys = new ArrayList<ParkingBoy>();
        parkingLots.add(parkingLot1);parkingLots.add(parkingLot2);parkingLots.add(parkingLot3);
        parkingBoys.add(parkingBoy1);parkingBoys.add(smartParkingBoy);

        ParkingLotManager manager = new ParkingLotManager(parkingBoys,parkingLots);
        manager.AddParkingBoy(superParkingBoy);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        //when
        ParkTicket ticketNormal1 = manager.park(car1);
        ParkTicket ticketNormal2 = manager.park(car2,manager.getParkingBoys().get(1),parkingLot2);
        ParkTicket ticketNull = manager.park(car3,superParkingBoy,parkingLot3);
        ParkTicket ticketNormal3 = manager.park(car4,manager.getParkingBoys().get(0));
        //then
        Assertions.assertNotNull(ticketNormal1);

    }

}
