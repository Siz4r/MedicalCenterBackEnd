package com.example.demo.Exceptions;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public class IncorrectIdInputException extends IllegalArgumentException {
    public IncorrectIdInputException() {
        super("No user with such id!");
    }
}
