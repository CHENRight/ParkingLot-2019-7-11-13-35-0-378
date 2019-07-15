package com.thoughtworks.tdd.Exception;

public class TicketMissingExcception extends RuntimeException{
    public TicketMissingExcception() {
        System.out.println("Please provide your parking ticket.");
    }
}
