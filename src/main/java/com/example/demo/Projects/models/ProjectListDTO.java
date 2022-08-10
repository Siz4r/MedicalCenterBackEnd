package com.example.demo.Projects.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter @Setter
public class ProjectListDTO {
    private UUID id;
    private String name;
    private Set<ProjectParticipantDTO> participants;
}
