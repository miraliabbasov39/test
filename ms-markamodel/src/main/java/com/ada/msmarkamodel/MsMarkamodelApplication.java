package com.ada.msmarkamodel;

import com.ada.msmarkamodel.dao.entity.Marka;
import com.ada.msmarkamodel.dao.entity.Model;
import com.ada.msmarkamodel.dao.repository.MarkaRepo;
import com.ada.msmarkamodel.dao.repository.ModelRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class MsMarkamodelApplication implements CommandLineRunner {
    private final MarkaRepo markaRepo;
    private final ModelRepo modelRepo;

    public static void main(String[] args) {
        SpringApplication.run(MsMarkamodelApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var markaEntity = Marka.builder()
                               .id(1L)
                               .name("MERCEDES")
                               .director("Johny")
                               .build();
        var markaEntity2 = Marka.builder()
                               .id(2L)
                               .name("BMW")
                               .director("Alex")
                               .build();
        var markaEntity3 = Marka.builder()
                                .id(3L)
                                .name("AUDI")
                                .director("Fare")
                                .build();

        var modelEntity = Model.builder()
                               .id(1L)
                               .name("CLS")
                               .color("BLACK")
                               .engine("5.5")
                               .createdYear(LocalDate.now())
                               .marka(markaEntity)
                               .build();
        var modelEntity2 = Model.builder()
                               .id(2L)
                               .name("M5")
                               .color("WHITE")
                               .engine("4.4")
                               .createdYear(LocalDate.now())
                               .marka(markaEntity2)
                               .build();
        var modelEntity3 = Model.builder()
                                .id(3L)
                                .name("RS7")
                                .color("RED")
                                .engine("6.0")
                                .createdYear(LocalDate.now())
                                .marka(markaEntity3)
                                .build();
        markaRepo.save(markaEntity);
        markaRepo.save(markaEntity2);
        markaRepo.save(markaEntity3);

        modelRepo.save(modelEntity);
        modelRepo.save(modelEntity2);
        modelRepo.save(modelEntity3);
    }
}
