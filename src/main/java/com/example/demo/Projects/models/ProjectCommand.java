package com.example.demo.Projects.models;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ProjectCommand(ProjectWebInput webInput, UUID id) {
}
