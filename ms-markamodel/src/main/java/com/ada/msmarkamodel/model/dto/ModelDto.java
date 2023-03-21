package com.ada.msmarkamodel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModelDto {
    private String name;
    private String engine;
    private String color;
    private LocalDate createdYear;
}
