package com.example.demo.Orders.models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class OrderListDTO {
    private UUID id;
    private String name;
}
