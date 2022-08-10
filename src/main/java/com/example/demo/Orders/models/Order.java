package com.example.demo.Orders.models;

import com.example.demo.Researches.researchResult.models.OrderResearch;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Builder
@Getter @Setter
public class Order {
    @Id
    private UUID id;

    private String name;
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    @OneToMany(
            mappedBy = "order",
            orphanRemoval = true,
            cascade = CascadeType.MERGE
    )
    private Set<OrderResearch> researchesResults;
}
