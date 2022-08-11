package com.example.demo.Researches.researchResult;

import com.example.demo.Exceptions.IncorrectIdInputException;
import com.example.demo.Orders.OrderRepository;
import com.example.demo.Researches.ResearchRepository;
import com.example.demo.Researches.researchResult.models.OrderResearch;
import com.example.demo.beans.idGenerator.IdGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class OrderResearchService {
    private final IdGenerator idGenerator;
    private final OrderResearchRepository orderResearchRepository;
    private final ResearchRepository researchRepository;
    private final OrderRepository orderRepository;
    private final ModelMapper mapper;

    public UUID addResearchResult(UUID researchId, UUID orderId) {
        try {
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
        } catch (IncorrectIdInputException e) {
            log.error("Error was thrown while adding research result: " + e.getMessage());
            throw e;
        }
    }

    public void deleteOrderResearch (UUID orderResearchId) {
        try {
            orderResearchRepository.deleteById(orderResearchId);
        } catch (Exception e) {
            log.error("Error was thrown while deleting research result: " + e.getMessage());
            throw e;
        }
    }

    public void updateOrderResearchResult(UUID id, String result) {
        try {
            var orderResearch = orderResearchRepository.findById(id).orElseThrow(IncorrectIdInputException::new);

            orderResearch.setResult(result);

            orderResearchRepository.save(orderResearch);
        } catch (Exception e) {
            log.error("Error was thrown while updating research result: " + e.getMessage());
            throw e;
        }
    }
}
