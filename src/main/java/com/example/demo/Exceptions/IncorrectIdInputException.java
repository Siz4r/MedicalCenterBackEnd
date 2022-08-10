package com.example.demo.Exceptions;

public class IncorrectIdInputException extends IllegalArgumentException {
    public IncorrectIdInputException() {
        super("No resource with such id!");
    }
}
