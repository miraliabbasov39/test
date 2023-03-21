package com.ada.msmarkamodel.dao.repository;

import com.ada.msmarkamodel.dao.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModelRepo extends JpaRepository<Model,Long> {
    Boolean existsByNameAndColor(String name, String color);

    Optional<Model> findByNameAndEngine (String name, String engine);
}
