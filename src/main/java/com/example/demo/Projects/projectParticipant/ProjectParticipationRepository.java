package com.example.demo.projectParticipant;

import com.example.demo.projectParticipant.models.ProjectParticipation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectParticipationRepository extends JpaRepository<ProjectParticipation, UUID> {
}
