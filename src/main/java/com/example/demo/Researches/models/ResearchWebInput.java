package com.example.demo.Researches.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
public class ResearchWebInput {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
