package com.example.demo.Researches.researchResult;

import com.example.demo.Exceptions.IncorrectIdInputException;
import com.example.demo.Orders.OrderRepository;
import com.example.demo.Researches.ResearchRepository;
import com.example.demo.Researches.researchResult.models.OrderResearch;
import com.example.demo.beans.idGenerator.IdGenerator;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ResearchService {
    private final IdGenerator idGenerator;
    private final OrderResearchRepository orderResearchRepository;
    private final ResearchRepository researchRepository;
    private final OrderRepository orderRepository;
    private final ModelMapper mapper;

    public UUID addResearchResult(UUID researchId, UUID orderId) {
        var research = researchRepository.findById(researchId).orElseThrow(IncorrectIdInputException::new);
        var order = orderRepository.findById(orderId).orElseThrow(IncorrectIdInputException::new);

        var orderResearch = OrderResearch.builder()
                .result("")
                .id(idGenerator.generateId()).build();

        orderResearch.addOrder(order);
        orderResearch.addResearch(research);

        researchRepository.save(research);
        orderRepository.save(order);

        return orderResearchRepository.save(orderResearch).getId();
    }

    public void deleteOrderResearch (UUID orderResearchId) {
        orderResearchRepository.deleteById(orderResearchId);
    }
}
