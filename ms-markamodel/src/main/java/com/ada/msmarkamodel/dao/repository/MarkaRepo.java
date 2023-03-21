package com.ada.msmarkamodel.dao.repository;

import com.ada.msmarkamodel.dao.entity.Marka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MarkaRepo extends JpaRepository<Marka, Long> {

    Boolean existsByName(String name);

    Optional<Marka> findByNameAndDirector(String name, String director);

    @Query("select m from Marka m")
    List<Marka> findAll();
}
