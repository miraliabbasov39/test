package com.ada.msmarkamodel.service;

import com.ada.msmarkamodel.dao.entity.Marka;
import com.ada.msmarkamodel.dao.entity.Model;
import com.ada.msmarkamodel.dao.repository.MarkaRepo;
import com.ada.msmarkamodel.dao.repository.ModelRepo;
import com.ada.msmarkamodel.mapper.ModelMapper;
import com.ada.msmarkamodel.model.dto.ModelDto;
import com.ada.msmarkamodel.model.exception.ForbiddenException;
import com.ada.msmarkamodel.model.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelService {
    private final ModelRepo repo;
    private final ModelMapper mapper;
    private final MarkaRepo markaRepo;

    public ModelDto getById(Long id) {
        var entity = getModelById(id);
        return mapper.entityToDto(entity);
    }

    public void add(ModelDto dto, Long markaId) {
        var exist = repo.existsByNameAndColor(dto.getName(), dto.getColor());
        if (exist) throw new ForbiddenException("Model already exist", "ALREADY_EXIST");
        var model = mapper.dtoToEntity(dto);
        var marka = getMarkaById(markaId);
        model.setMarka(marka);
        repo.save(model);
    }

    public void update(ModelDto dto, Long id) {
        var entity = getModelById(id);
        entity.setName(dto.getName());
        entity.setColor(dto.getColor());
        entity.setEngine(dto.getEngine());
        entity.setCreatedYear(dto.getCreatedYear());
        repo.save(entity);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    private Model getModelById(Long id) {
        return repo.findById(id).orElseThrow(( ) -> new NotFoundException("Model not found", "NOT_FOUND"));
    }

    private Marka getMarkaById(Long id) {
        return markaRepo.findById(id).orElseThrow(( ) -> new NotFoundException("Marka not found", "NOT_FOUND"));
    }
}
