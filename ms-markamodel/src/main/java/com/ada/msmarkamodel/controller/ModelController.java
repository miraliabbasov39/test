package com.ada.msmarkamodel.controller;

import com.ada.msmarkamodel.model.dto.ModelDto;
import com.ada.msmarkamodel.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/model")
@RequiredArgsConstructor
public class ModelController {
    private final ModelService service;

    @GetMapping("/{id}")
    public ModelDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public void add(@RequestBody ModelDto dto, @RequestParam Long markaId) {
        service.add(dto, markaId);
    }

    @PostMapping("/update/{id}")
    public void update(@RequestBody ModelDto dto, @PathVariable Long id) {
        service.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
