package com.example.demo.Projects;

import com.example.demo.Projects.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface ProjectRepository extends JpaRepository<Project, UUID> {
}
