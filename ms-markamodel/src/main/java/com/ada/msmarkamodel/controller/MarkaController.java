package com.ada.msmarkamodel.controller;

import com.ada.msmarkamodel.model.dto.MarkaDto;
import com.ada.msmarkamodel.service.MarkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/marka")
@RequiredArgsConstructor
public class MarkaController {
    private final MarkaService service;

    @GetMapping("/{id}")
    public MarkaDto getMarkaById(@PathVariable Long id) {
        return service.getMarka(id);
    }

    @PostMapping
    public void addMarka(@RequestBody MarkaDto dto) {
        service.addMarka(dto);
    }

    @PostMapping("/{id}")
    public void update(@RequestBody MarkaDto dto, @PathVariable Long id) {
        service.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping
    public List<MarkaDto> getAll( ) {
        return service.getAll();
    }
}
