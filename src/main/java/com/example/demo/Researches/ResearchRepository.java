package com.example.demo.Researches;

import com.example.demo.Researches.models.Research;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResearchRepository extends JpaRepository<Research, UUID> {
}
