package com.example.demo.Projects.models;

import lombok.Builder;

import java.util.UUID;

@Builder
public class ProjectCommand {
    private ProjectWebInput webInput;
    private UUID id;
}
