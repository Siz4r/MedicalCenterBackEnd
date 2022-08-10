package com.example.demo.Researches.models;

import com.example.demo.Researches.researchResult.models.OrderResearch;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.UUID;

@Entity
@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Research {
    @Id
    private UUID id;
    private String name;
    private String description;

    @OneToMany(
            mappedBy = "research",
            orphanRemoval = true,
            cascade = CascadeType.MERGE
    )
    private Set<OrderResearch> orderResearches;
}
