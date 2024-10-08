package org.example.services;

import org.example.model.modelDTO;

import java.util.List;
import java.util.Optional;

public interface service {


    void addModel(modelDTO m);

    List<modelDTO> getAllModels();

    Optional<modelDTO> getModelById(long id);

    void deleteModelById(long id);
}
