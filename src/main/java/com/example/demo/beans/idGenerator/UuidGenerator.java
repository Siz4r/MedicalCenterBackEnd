package com.example.demo.beans.idGenerator;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidGenerator implements IdGenerator {
    @Override
    public UUID generateId() {
        return UUID.randomUUID();
    }
}
