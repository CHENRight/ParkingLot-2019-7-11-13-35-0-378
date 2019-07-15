package com.thoughtworks.tdd;

public interface Parkable {
    ParkTicket park(Car car);

    Car fetch(ParkTicket ticket);
}
