package com.example.demo.Orders.models;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;
import java.util.UUID;

@Getter @Builder
public class OrderCommand {
    private OrderWebInput webInput;
    private UUID id;
    private Set<UUID> ids;
}
