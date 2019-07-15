package com.thoughtworks.tdd.Exception;

public class ErrorTicketException extends RuntimeException {
    public ErrorTicketException() {
        System.out.println("Unrecognized parking ticket.");
    }
}
