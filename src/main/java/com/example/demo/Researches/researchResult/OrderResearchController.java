package com.example.demo.Researches.researchResult;

import com.example.demo.Researches.researchResult.models.OrderResearchWebInput;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/orderResearches/")
public class OrderResearchController {
    private final OrderResearchService orderResearchService;


    @PostMapping("/research/{researchId}/order/{orderId}")
    @ResponseStatus(HttpStatus.CREATED)
    public UUID createOrderResearch(@PathVariable("researchId") UUID researchId,
                                    @PathVariable("orderId") UUID orderId) {
        return orderResearchService.addResearchResult(researchId, orderId);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrderResearchById(@PathVariable("id") UUID id) {
        orderResearchService.deleteOrderResearch(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Resource updated succesfully")
    public void updateOrderResearchResult(@PathVariable("id") UUID id, @Valid @RequestBody OrderResearchWebInput webInput) {
        orderResearchService.updateOrderResearchResult(id, webInput.getResult());
    }
}
