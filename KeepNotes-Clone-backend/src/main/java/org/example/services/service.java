package org.example.services;

import org.example.model.model;

import java.util.List;

public interface service {


    void addModel(model m);

    List<model> getAllModels(model m);
}
