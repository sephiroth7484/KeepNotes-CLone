package org.example.services;

import org.example.model.model;

import java.util.List;
import java.util.Optional;

public interface service {


    void addModel(model m);

    List<model> getAllModels();

    Optional<model> getModelById(long id);

    void deleteModelById(long id);
}
