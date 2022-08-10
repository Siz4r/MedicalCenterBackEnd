package com.example.demo.Researches.models;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;
import java.util.UUID;

@Builder
@Getter
public class ResearchCommand {
    private ResearchWebInput webInput;
    private UUID id;
    private Set<UUID> ids;
}
