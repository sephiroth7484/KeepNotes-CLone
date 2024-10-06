package org.example.services;

import org.example.model.model;
import org.example.repository.repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class serviceImpl implements service {

    @Autowired
    repo JPARepoObj;
    @Override
    public void addModel(model m) {
    this.JPARepoObj.save(m);
    }

    @Override
    public List<model> getAllModels(model m) {
        return this.JPARepoObj.findAll();
    }
}
