package com.thoughtworks.tdd.Exception;

public class NotEnoughPosition extends RuntimeException {
    public NotEnoughPosition() {
        System.out.println("Not enough position.");
    }
}
