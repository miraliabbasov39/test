package com.ada.msmarkamodel.mapper;

import com.ada.msmarkamodel.dao.entity.Model;
import com.ada.msmarkamodel.model.dto.ModelDto;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {

    public ModelDto entityToDto(Model entity) {
        return ModelDto.builder()
                       .name(entity.getName())
                       .color(entity.getColor())
                       .engine(entity.getEngine())
                       .createdYear(entity.getCreatedYear())
                       .build();
    }

    public Model dtoToEntity(ModelDto dto) {
        return Model.builder()
                    .name(dto.getName())
                    .color(dto.getColor())
                    .engine(dto.getEngine())
                    .createdYear(dto.getCreatedYear())
                    .build();
    }
}
