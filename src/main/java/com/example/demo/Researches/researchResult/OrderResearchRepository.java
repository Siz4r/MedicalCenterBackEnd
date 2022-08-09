package com.example.demo.Researches.researchResult;

import com.example.demo.Researches.researchResult.models.ResearchResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResearchResultRepository extends JpaRepository<ResearchResult, UUID> {
}
