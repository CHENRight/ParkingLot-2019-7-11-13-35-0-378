package com.thoughtworks.tdd;

import java.util.List;

public interface Parkable {
    ParkTicket park(Car car);

    Car fetch(ParkTicket ticket);

    boolean contains(ParkTicket ticket);

    boolean isFull();
}
