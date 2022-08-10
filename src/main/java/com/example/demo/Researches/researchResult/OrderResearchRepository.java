package com.example.demo.Researches.researchResult;

import com.example.demo.Researches.researchResult.models.OrderResearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderResearchRepository extends JpaRepository<OrderResearch, UUID> {
}
