package com.example.demo.Researches.models;

import com.example.demo.Researches.researchResult.models.OrderResearchListDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter @Setter
public class ResearchListDTO {
    private UUID id;
    private String name;
    private String description;
    private Set<OrderResearchListDTO> orderResearches;
}
