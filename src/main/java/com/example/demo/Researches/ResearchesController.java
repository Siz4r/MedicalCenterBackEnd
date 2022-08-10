package com.example.demo.Researches;

import com.example.demo.Researches.models.ResearchCommand;
import com.example.demo.Researches.models.ResearchListDTO;
import com.example.demo.Researches.models.ResearchWebInput;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api/researches")
@AllArgsConstructor
public class ResearchesController {
    private final ResearchService researchService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<ResearchListDTO> getResearches() {
        return researchService.getResearches();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID createResearch(@Valid @RequestBody ResearchWebInput webInput) {
        return researchService.createResearch(ResearchCommand.builder()
                .webInput(webInput).build());
    }

    @PutMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Resource updated successfully")
    public void updateResearch(@Valid @RequestBody ResearchWebInput webInput, @PathVariable("id") UUID id) {
        researchService.updateResearch(ResearchCommand.builder()
                .webInput(webInput)
                .id(id).build());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteResearchById(@PathVariable("id") UUID id) {
        researchService.deleteById(ResearchCommand.builder().id(id).build());
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllResearchesByIds(@RequestBody Set<UUID> ids) {
        researchService.deleteAllByIds(ResearchCommand.builder().ids(ids).build());
    }

}
