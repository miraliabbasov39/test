package com.ada.msmarkamodel.service;

import com.ada.msmarkamodel.dao.entity.Marka;
import com.ada.msmarkamodel.dao.repository.MarkaRepo;
import com.ada.msmarkamodel.mapper.MarkaMapper;
import com.ada.msmarkamodel.model.dto.MarkaDto;
import com.ada.msmarkamodel.model.exception.ForbiddenException;
import com.ada.msmarkamodel.model.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MarkaService {
    private final MarkaRepo markaRepo;
    private final MarkaMapper mapper;

    public MarkaDto getMarka(Long id) {
        var entity = getMarkaById(id);
        return mapper.entityToDto(entity);
    }


    public void addMarka(MarkaDto dto) {
        var exist = markaRepo.existsByName(dto.getName());
        if (exist) throw new ForbiddenException("Marka already exist", "ALREADY_EXIST");
        var entity = mapper.dtoToEntity(dto);
        markaRepo.save(entity);
    }

    public void update(MarkaDto dto, Long id) {
        var entity = getMarkaById(id);
        entity.setName(dto.getName());
        entity.setDirector(dto.getDirector());
        markaRepo.save(entity);
    }

    public void deleteById(Long id) {
        markaRepo.deleteById(id);
    }

    public List<MarkaDto> getAll(){
        var entits = markaRepo.findAll();
        return entits.stream().map(mapper::entityToDto).collect(Collectors.toList());
    }
    private Marka getMarkaById(Long id) {
        return markaRepo.findById(id).orElseThrow(( ) -> new NotFoundException("Marka not found", "NOT_FOUND"));
    }
}
