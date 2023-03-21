package com.ada.msmarkamodel.mapper;

import com.ada.msmarkamodel.dao.entity.Marka;
import com.ada.msmarkamodel.model.dto.MarkaDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarkaMapper {

    public MarkaDto entityToDto(Marka entity) {
        return MarkaDto.builder()
                       .director(entity.getDirector())
                       .name(entity.getName())
                       .build();
    }

    public Marka dtoToEntity(MarkaDto dto) {
        return Marka.builder()
                    .director(dto.getDirector())
                    .name(dto.getName())
                    .build();
    }

}
