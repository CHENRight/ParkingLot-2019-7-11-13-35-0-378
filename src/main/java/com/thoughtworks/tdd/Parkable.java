package com.thoughtworks.tdd;

public interface Parkable {
    public ParkTicket park(Car car);

    Car fetch(ParkTicket ticket);
}
