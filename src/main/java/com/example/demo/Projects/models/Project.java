package com.example.demo.Projects.models;

import com.example.demo.Projects.projectParticipant.models.ProjectParticipation;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Project {
    @Id
    private UUID id;

    private String name;

    @OneToMany(
            mappedBy = "project",
            orphanRemoval = true,
            cascade = CascadeType.MERGE
    )
    private Set<ProjectParticipation> participants;

    public void addProjectParticipation(ProjectParticipation projectParticipation) {
        participants.add(projectParticipation);
    }
}
