package com.example.demo.Researches.researchResult.models;

import com.example.demo.Orders.models.Order;
import com.example.demo.Researches.models.Research;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ResearchResult {
    @Id
    private UUID id;

    private String result;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;

    @ManyToOne
    @JoinColumn(name = "research_id")
    @JsonBackReference
    private Research research;

    public void addResearch(Research research) {
        setResearch(research);
        research.getResearchesResults().add(this);
    }

    public void addOrder(Order order) {
        setOrder(order);
        order.getResearchesResults().add(this);
    }
}
