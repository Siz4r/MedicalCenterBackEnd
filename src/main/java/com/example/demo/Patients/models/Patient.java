package com.example.demo.Patients.models;

import com.example.demo.Addresses.models.Address;
import com.example.demo.Projects.projectParticipant.models.ProjectParticipation;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
public class Patient {
    @Id
    private UUID id;

    private String firstName;
    private String lastName;

    private String pesel;
    private String email;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(
            orphanRemoval = true,
            cascade = CascadeType.MERGE,
            mappedBy = "patient"
    )
    private Set<ProjectParticipation> projectParticipations;

    public void setAddress(Address address) {
        this.address = address;
        address.setPatient(this);
    }

    public void addProjectParticipation(ProjectParticipation projectParticipation) {
        projectParticipations.add(projectParticipation);
        projectParticipation.setPatient(this);
    }
}
