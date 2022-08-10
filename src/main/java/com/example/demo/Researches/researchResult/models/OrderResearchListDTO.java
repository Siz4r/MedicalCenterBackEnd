package com.example.demo.Researches.researchResult.models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class OrderResearchListDTO {
    private UUID id;
    private String result;
    private UUID orderId;
    private String orderName;
}
